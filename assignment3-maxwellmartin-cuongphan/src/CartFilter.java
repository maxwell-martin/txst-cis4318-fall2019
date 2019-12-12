import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Filter for all requests.
public class CartFilter implements Filter {
    // Execute the filter.
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // Convert ServletRequest to HttpServletRequest.
        HttpServletRequest request = (HttpServletRequest) req;

        // Get Session object or create a new one if session doesn't exist.
        HttpSession session = request.getSession();

        // Get Cart object from the Session object.
        Cart cart = (Cart) session.getAttribute("cart");

        // Check if Cart object is null.
        if (cart == null) {
            // Get all cookies from the HttpServletRequest object.
            Cookie[] cookies = request.getCookies();

            // Get value of "cart" cookie.
            String cartCookieString = CookieUtil.getCookieValue(cookies, "cart");

            // Check if "cart" cookie exists.
            if (cartCookieString.equals("")) {
                // Create a new Cart object.
                cart = new Cart();
            }
            else {
                // Create Cart object from the "cart" cookie.
                cart = CookieUtil.createCartFromCookie(cartCookieString);
            }
        }

        // Add Cart object to session.
        session.setAttribute("cart", cart);

        // Pass request and response to next item in chain (servlet or page).
        chain.doFilter(req, resp);
    }
}
