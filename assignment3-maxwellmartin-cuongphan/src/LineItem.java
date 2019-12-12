import java.io.Serializable;

// Class for line items.
public class LineItem implements Serializable {
    private Product product;
    private int quantity;

    // Empty constructor.
    public LineItem() {
        product = null;
        quantity = 0;
    }

    // Parameterized constructor.
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate subtotal of the line item.
    public double getSubTotal() {
        return product.getProductPrice() * quantity;
    }
}
