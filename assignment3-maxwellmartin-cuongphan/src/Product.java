import java.io.Serializable;

// Class for products.
public class Product implements Serializable {
    private String productCode;
    private double productPrice;
    private String productDescription;

    // Empty constructor.
    public Product() {
        productCode = "";
        productPrice = 0.0;
        productDescription = "";
    }

    // Parameterized constructor.
    public Product(String productCode, double productPrice, String productDescription) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
