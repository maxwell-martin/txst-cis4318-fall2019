import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AuthServlet")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> arrLstUsers = new ArrayList<>();
        arrLstUsers.add(new User("joe.smith", "1234"));
        arrLstUsers.add(new User("harold.arnold", "1111"));
        arrLstUsers.add(new User("sally.johnson", "9999"));

        String fromPage = request.getParameter("fromPage");
        String url = "/index.html";

        if (fromPage == null) {
            fromPage = "home";
        }

        if (fromPage.equals("home")) {
            url = "/index.html";
        }
        else if (fromPage.equals("idxSignUp")) {
            url = "/signup.jsp";
        }
        else if (fromPage.equals("idxLogin")) {
            url = "/login.jsp";
        }
        else if (fromPage.equals("signUp")) {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            if (checkIfExists(arrLstUsers, user)) {
                url = "/login.jsp";
            }
            else {
                arrLstUsers.add(user);
                url = "/index.html";
            }
        }
        else if (fromPage.equals("login")) {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            if (checkIfExists(arrLstUsers, user)) {
                request.setAttribute("user", user);
                url = "/success.jsp";
            }
            else {
                url = "/signup.jsp";
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean checkIfExists(ArrayList<User> aList, User u1) {
        boolean exists = false;
        int count = 0;

        while (exists == false && count < aList.size()) {
            if (aList.get(count).getUsername().equals(u1.getUsername())) {
                exists = true;
            }
            count++;
        }

        return exists;
    }
}
