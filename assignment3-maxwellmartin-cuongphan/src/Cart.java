import java.io.Serializable;
import java.util.ArrayList;

// Class for shopping cart.
public class Cart implements Serializable {
    // Holds all of the carts line items.
    private ArrayList<LineItem> lineItems;

    // Empty constructor.
    public Cart() {
        lineItems = new ArrayList<>();
    }

    // Parameterized constructor.
    public Cart(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    // Add a LineItem object to the Cart.
    public void addItem(LineItem lineItem) {
        // Get product code from new line item.
        String productCode = lineItem.getProduct().getProductCode();

        // Loop through all of the Cart's line items.
        for (LineItem li : lineItems) {

            // Check if Cart has a line item with the same product code.
            if (li.getProduct().getProductCode().equals(productCode)) {

                // Update the line item's quantity and exit function.
                li.setQuantity(li.getQuantity() + lineItem.getQuantity());
                return;
            }
        }

        // Line item doesn't exist in Cart. Add line item to Cart.
        lineItems.add(lineItem);
    }

    // Get total cost of all line items in Cart.
    public double getTotal() {
        double total = 0.0;

        // Loop through all of the Cart's line items.
        for(LineItem li : lineItems) {

            // Increment the total by line item's subtotal.
            total += li.getSubTotal();
        }

        return total;
    }

    // Clear the Cart by setting current ArrayList of line items to empty ArrayList.
    public void clearCart() {
        lineItems = new ArrayList<>();
    }
}
