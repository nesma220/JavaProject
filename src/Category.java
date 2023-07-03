import java.util.List;

public class Category {

    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private List<Product> products;
    private int NumberOfCategory;

    Category() {
    }

    public Category(String categoryId, String categoryName, String categoryDescription, List<Product> products,
            int numberOfCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.products = products;
        NumberOfCategory = numberOfCategory;
    }

    public int getNumberOfCategory() {
        return NumberOfCategory;
    }

    public void setNumberOfCategory(int numberOfCategory) {
        NumberOfCategory = numberOfCategory;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

        @Override
    public String toString(){
        return "Name: " + this.getCategoryName() + "\nPassword: " + this.getCategoryDescription() 
                + "\n id: " + this.getCategoryId() ;
    }

}
