import javax.servlet.http.Cookie;

// Helper class do deal with cookies.
public class CookieUtil {
    // Get the value of a cookie.
    public static String getCookieValue(Cookie[] cookies, String cookieName) {
        String cookieValue = "";

        // Check if cookies array has cookies in it.
        if (cookies != null) {
            // Loop through all cookies.
            for(Cookie cookie : cookies) {
                // Check if cookie you are looking for exists in cookie array.
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }

        return cookieValue;
    }

    // Take a Cart object and convert it into a Cookie object.
    public static Cookie createCartAsCookie(Cart cart) {
        String cookieString = "";

        // Loop through all LineItem objects in Cart.
        for (LineItem li : cart.getLineItems()) {
            // Get the Product object associated with the current line item.
            Product product = li.getProduct();

            // Store product attributes as String objects.
            String productCode = product.getProductCode();
            String productPrice = Double.toString(product.getProductPrice());
            String productDescription = product.getProductDescription();

            // Store line item's quantity as a String object.
            String lineItemQuantity = Integer.toString(li.getQuantity());

            // Add to cookie string product and line item information using delimiters.
            cookieString += productCode + "*" + productPrice + "*"
                    + productDescription + "*" + lineItemQuantity + "|";
        }

        // Create Cookie object from concatenated cookie String object.
        Cookie cookie = new Cookie("cart", cookieString);
        cookie.setMaxAge(60*60*24*365);
        cookie.setPath("/");

        return cookie;
    }

    // Take the String for the cart cookie and convert back to a Cart object.
    public static Cart createCartFromCookie(String cartCookieString) {
        Cart cart = new Cart();

        // Split String into line items.
        String[] lineItems = cartCookieString.split("\\|");

        // Loop all line item Strings.
        for (String li : lineItems) {
            // Split each line item into parts.
            String[] pieces = li.split("\\*");

            // Get product and line item info from pieces Array.
            String productCode = pieces[0];
            double productPrice = Double.parseDouble(pieces[1]);
            String productDescription = pieces[2];
            int lineItemQuantity = Integer.parseInt(pieces[3]);

            // Create Product and LineItem objects from pieces values.
            Product product = new Product(productCode, productPrice, productDescription);
            LineItem lineItem = new LineItem(product, lineItemQuantity);

            // Add LineItem object to cart.
            cart.addItem(lineItem);
        }

        return cart;
    }

    // Remove the cart cookie from browser.
    public static Cookie clearCartCookie(Cookie[] cookies, String cartCookieName) {
        Cookie clearedCookie = null;

        // Check if cookies array has cookies in it.
        if (cookies != null) {
            // Loop through all cookies in Array.
            for(Cookie cookie : cookies) {
                // Check if cart cookie exists in Array.
                if (cartCookieName.equals(cookie.getName())) {
                    // Clear cookie.
                    clearedCookie = cookie;
                    clearedCookie.setMaxAge(0);
                    clearedCookie.setPath("/");
                }
            }
        }

        return clearedCookie;
    }
}
