import beans.Order;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BaseballServlet")
public class BaseballServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromPage = request.getParameter("fromPage");
        String url = "/index.jsp";

        if (fromPage.equals("index")) {
            User user = new User();
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setCity(request.getParameter("city"));
            user.setState(request.getParameter("state"));
            user.setZipCode(Integer.parseInt(request.getParameter("zipCode")));

            if (request.getParameter("mailingList") == null) {
                user.setMailingList(false);
            } else {
                user.setMailingList(true);
            }

            if (request.getParameter("recommend").equals("Yes")) {
                user.setRecommendToFriend(true);
            } else {
                user.setRecommendToFriend(false);
            }

            Order order = new Order();
            order.setShipping(request.getParameter("shipping"));
            order.setCards(request.getParameterValues("cards"));

            request.setAttribute("user", user);
            request.setAttribute("order", order);

            url = "/confirmation.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
