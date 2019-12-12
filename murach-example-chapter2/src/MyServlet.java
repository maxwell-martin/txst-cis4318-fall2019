import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("fromPage");
        String url = "";

        if (action.equals("blahblah")) {
            String sfName = request.getParameter("firstName");
            String slName = request.getParameter("lastName");
            String semail = request.getParameter("email");

            User u1 = new User(sfName, slName, semail);

            request.setAttribute("myUser", u1);

            url = "/thanks.jsp";
        }
        else if (action.equals("thk")) {
            url = "/index.html";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
