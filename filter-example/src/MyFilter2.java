import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "MyFilter2")
public class MyFilter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // ArrayList of dummy users.
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Anna", "anna@yahoo.com"));
        users.add(new User("John", "john@yahoo.com"));

        // Get values entered in textboxes.
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");

        // Create User object
        User user = new User(userName, userEmail);

        // Checks if User object exists in list
        if (users.contains(user)) {
            // Do next action.
            chain.doFilter(req, resp);
        }
        else {
            // Convert ServletResponse to HttpServletResponse
            HttpServletResponse httpResp = (HttpServletResponse) resp;

            // Redirect user to homepage.
            httpResp.sendRedirect("/index.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
