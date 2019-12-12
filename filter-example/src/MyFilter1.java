import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter1")
public class MyFilter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // Get value entered in textboxes.
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");

        // Check if user entered a value in textboxes.
        if (userName.trim().length() != 0 && userEmail.trim().length() != 0) {
            // Go to next action in chain.
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
