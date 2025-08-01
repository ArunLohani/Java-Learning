package Product;
import java.util.Objects;
public class Product {
    private static int productCounter = 0;
    private final String productId;
    private String productName;
    private String productCategory;
    private float price;
    public Product(String productName, String productCategory, float price) {
        productCounter++;
        this.productId = "P-" + productCounter;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public float getProductPrice() {
        return price;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public void setProductPrice(float price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }
    @Override
    public int hashCode() {
        return  productId.hashCode();
    }

}