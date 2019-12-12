import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    // Method that handles any post requests to servlet.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Variable to hold forwarding url.
        String url = "";

        // Get value from action in hidden input.
        String action = request.getParameter("action");

        // If null, send to homepage.
        if (action == null) {
            action = "signup";
        }

        // If action is signup, make forwarding url homepage.
        if (action.equals("signup")) {
            url = "/index.jsp";
        }
        // If action is insert, insert into database and forward to results page.
        else if (action.equals("insert")) {
            // User object to insert into database.
            User user = new User();

            // Set user properties with values from textboxes.
            user.setUser_fn(request.getParameter("fnText"));
            user.setUser_ln(request.getParameter("lnText"));
            user.setUser_un(request.getParameter("unText"));
            user.setUser_pw(request.getParameter("pwText"));

            // Insert user into database
            DatabaseTools.insert(user);

            // Get all users from database
            ArrayList<User> users = DatabaseTools.selectAllUsers();

            // Set list of users as attribute of request
            request.setAttribute("users", users);

            // Set message attribute
            request.setAttribute("message", "");

            // Set forwarding url to results page.
            url = "/results.jsp";
        }
        // If action is insert, check to see if update or delete button was clicked.
        else if (action.equals("modify")) {
            // If update clicked, update user in database.
            if (request.getParameter("update") != null) {
                // Get values entered in textboxes.
                String id = request.getParameter("idText");
                String fn = request.getParameter("fnText");
                String ln = request.getParameter("lnText");
                String un = request.getParameter("unText");
                String pw = request.getParameter("pwText");
                int convertedID;

                // Check if values in textboxes are blank.
                if (id == null || fn == null || ln == null || un == null || pw == null ||
                        id.isEmpty() || fn.isEmpty() || ln.isEmpty() || un.isEmpty() || pw.isEmpty()) {
                    // Get all users from database
                    ArrayList<User> users = DatabaseTools.selectAllUsers();

                    // Set list of users as attribute of request
                    request.setAttribute("users", users);

                    // Set message attribute
                    request.setAttribute("message", "Please make sure all textboxes are filled in when updating.");

                    // Set forwarding url to results page.
                    url = "/results.jsp";
                }
                else {
                    try {
                        // Convert string id to integer.
                        convertedID = Integer.parseInt(id);

                        // Create user object with updated values.
                        User user = new User(convertedID, fn, ln, un, pw);

                        // Update user in database
                        DatabaseTools.update(user);

                        // Get all users from database
                        ArrayList<User> users = DatabaseTools.selectAllUsers();

                        // Set list of users as attribute of request
                        request.setAttribute("users", users);

                        // Set message attribute
                        request.setAttribute("message", "");

                        // Set forwarding url to results page.
                        url = "/results.jsp";
                    } catch (Exception ex) {
                        // Get all users from database
                        ArrayList<User> users = DatabaseTools.selectAllUsers();

                        // Set list of users as attribute of request
                        request.setAttribute("users", users);

                        // Set message attribute
                        request.setAttribute("message", "Error: " + ex.getMessage());

                        // Set forwarding url to results page.
                        url = "/results.jsp";
                    }
                }
            // If delete clicked, delete user from database.
            } else if (request.getParameter("delete") != null) {
                // Get id entered in textbox.
                String id = request.getParameter("idText");
                int convertedID;

                // Check if id entered is blank.
                if (id == null || id.isEmpty()) {
                    // Get all users from database
                    ArrayList<User> users = DatabaseTools.selectAllUsers();

                    // Set list of users as attribute of request
                    request.setAttribute("users", users);

                    // Set message attribute
                    request.setAttribute("message", "Please make sure ID is filled in when deleting.");

                    // Set forwarding url to results page.
                    url = "/results.jsp";
                }
                else {
                    try {
                        // Convert string id to integer.
                        convertedID = Integer.parseInt(id);

                        // Create user object to be deleted from database.
                        User user = new User();

                        // Set user id.
                        user.setUser_id(convertedID);

                        // Delete user from database.
                        DatabaseTools.delete(user);

                        // Get all users from database.
                        ArrayList<User> users = DatabaseTools.selectAllUsers();

                        // Set list of users as attribute of request.
                        request.setAttribute("users", users);

                        // Set message attribute.
                        request.setAttribute("message", "");


                        url = "/results.jsp";
                    } catch (Exception ex) {
                        // Get all users from database
                        ArrayList<User> users = DatabaseTools.selectAllUsers();

                        // Set list of users as attribute of request
                        request.setAttribute("users", users);

                        // Set message attribute
                        request.setAttribute("message", "Error:" + ex.getMessage());

                        // Set forwarding url to results page.
                        url = "/results.jsp";
                    }
                }
            }
        }

        // Forward request and response to specified URL.
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // Execute doPost method on any get requests.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
