import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "";
        String action = request.getParameter("fromPage");

        System.out.println(action);

        if (action.equals("page1")) {
            String fn = request.getParameter("fn");
            String ln = request.getParameter("ln");
            String un = request.getParameter("un");
            String pw = request.getParameter("pw");

            User u1 = new User(111, fn, ln, un, pw);

            request.setAttribute("aDude", u1);

            // Encrypt password
            pw = SecurePassword.lockPassword(pw);

            // Insert user into database
            DatabaseTools.insert(fn, ln, un, pw);

            // Get all users from database
            ArrayList<User> myData = DatabaseTools.selectAllUsers();

            // Set list of users as attribute of request
            request.setAttribute("users", myData);

            url = "/page2.jsp";
        }
        else if (action.equals("1")) {

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
