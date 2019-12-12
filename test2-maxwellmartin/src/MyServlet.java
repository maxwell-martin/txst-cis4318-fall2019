import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "/index.jsp";

        if (action == null) {
            action = "home";
        }

        if (action.equals("home")) {
            url = "/index.jsp";
        }
        else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(0, firstName, lastName, email);

            DatabaseTools.insert(user);

            request.setAttribute("user", user);

            url = "/thanks.jsp";
        }
        else if (action.equals("returnOrManage")) {
            if (request.getParameter("return") != null) {
                url = "/index.jsp";
            }
            else if (request.getParameter("manage") != null) {
                ArrayList<User> users = DatabaseTools.selectAllUsers();
                request.setAttribute("users", users);
                url = "/modify.jsp";
            }
        }
        else if (action.equals("modify")) {
            if (request.getParameter("update") != null) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");

                User user = new User(0, firstName, lastName, email);

                DatabaseTools.update(user);

                ArrayList<User> users = DatabaseTools.selectAllUsers();

                request.setAttribute("users", users);

                url = "/modify.jsp";
            }
            else if (request.getParameter("delete") != null) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");

                DatabaseTools.delete(firstName, lastName);

                ArrayList<User> users = DatabaseTools.selectAllUsers();

                request.setAttribute("users", users);

                url = "/modify.jsp";
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
