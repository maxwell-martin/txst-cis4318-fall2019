import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

// Servlet for all requests to "/cart".
public class CartServlet extends HttpServlet {
    // Execute on POST HTTP request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the value from the hidden field (named "action").
        String action = request.getParameter("action");
        String url = "";

        // Check if action does not have a value.
        if (action == null || action.equals("")) {
            // Set to default action.
            action = "home";
        }

        // Default action.
        if (action.equals("home")) {
            // Url set to homepage.
            url = "/index.jsp";
        }
        // Action when any of the "Add to Cart" buttons are clicked.
        else if (action.equals("addToCart")) {
            // Get product code from hidden field (named "productCode").
            String productCode = request.getParameter("productCode");

            // Get session or create if it doesn't exist.
            HttpSession session = request.getSession();

            // Get Cart object from the session.
            Cart cart = (Cart) session.getAttribute("cart");

            // Get Product by product code.
            Product product = getProduct(productCode);

            // Create LineItem object. Add Product and quantity to it.
            LineItem lineItem = new LineItem(product, 1);

            // Add line item to Cart object.
            cart.addItem(lineItem);

            // Create cart cookie and add to HttpServletResponse object.
            Cookie cookie = CookieUtil.createCartAsCookie(cart);
            response.addCookie(cookie);

            // Add cart to session.
            session.setAttribute("cart", cart);

            // Keep user on homepage so they can add more items to cart.
            url = "/index.jsp";
        }
        // Action when "Checkout" button is clicked.
        else if (action.equals("checkout")) {
            // Send user to checkout page.
            url = "/checkout.jsp";
        }
        // Action when "Clear Cart" button is clicked.
        else if (action.equals("clearCart")) {
            // Get all cookies.
            Cookie[] cookies = request.getCookies();

            // Clear the cart cookie.
            Cookie cartCookie = CookieUtil.clearCartCookie(cookies, "cart");

            // If cookie exists, add to response to remove it.
            if (cartCookie != null) {
                response.addCookie(cartCookie);
            }

            // Get session or create session.
            HttpSession session = request.getSession();

            // Get cart from session.
            Cart cart = (Cart) session.getAttribute("cart");

            // Clear cart.
            cart.clearCart();

            // Add cleared cart to session.
            session.setAttribute("cart", cart);

            // Keep user on checkout page.
            url = "/checkout.jsp";
        }

        // Forward request and response to designated URL.
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // Get Product object by product code.
    private Product getProduct(String productCode) {
        // Array of hard-coded products.
        Product[] products = {
                new Product("1", 100.0, "LeBron-James-jersey"),
                new Product("2", 80.0, "Giannis-Antetokounmpo-jersey"),
                new Product("3", 50.0, "Jayson-Tatum-jersey"),
                new Product("4", 90.0, "Stephen-Curry-jersey")
        };

        switch(productCode) {
            // Product code for Lebron James jersey.
            case "1":
                return products[0];
            // Product code for Giannis Antetokounmpo jersey.
            case "2":
                return products[1];
            // Product code for Jayson Tatum jersey.
            case "3":
                return products[2];
            // Product code for Stephen Curry jersey.
            case "4":
                return products[3];
            default:
                return null;
        }
    }

    // Execute on GET HTTP request.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do the method associated with POST HTTP requests.
        doPost(request, response);
    }
}
