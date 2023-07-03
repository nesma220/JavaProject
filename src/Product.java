import java.util.Arrays;
import java.util.List;

public class Product {

    private String productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private List<String> colors;

    public Product(String productID, String productName, String productDescription, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setColors(List<String> colorsList) {
        this.colors = colorsList;
    }

    public List<String> getColors() {
        return colors;
    }
    
    public String displayColors() {
        return Arrays.toString(colors.toArray());
    }
    
    @Override
    public String toString(){
        return "Product ID: " + this.getProductID() + "\nProduct Name: " + this.getProductName()
                + "\n Product Description: " + this.getProductDescription() + "\n Product Price: " + this.getProductPrice()
                + "\n Product Quantity: " + this.getProductQuantity() + "\n Colors: " + this.displayColors();
    }
}