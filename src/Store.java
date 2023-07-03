import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Category> categories;
    private List<Product> products;
    private List<Customer> customer;

    public Store() {
        categories = new ArrayList<>();
        products = new ArrayList<>();
        customer = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // add product for category
    public void addtoCategory(String categoryId, Product product) {
        for (Category category : categories) {
            if (category.getCategoryId().equals(categoryId)) {
                category.getProducts().add(product);
                break;
            }
        }
    }

    /// Update Category = ID + Desc + Name
    // Update category Desc
    public void updateCategoryDesc(String categoryDescString, int index) {
        this.categories.get(index).setCategoryDescription(categoryDescString);
    }

    // Update category ID
    public void updateCategoryId(int index, String newId) {
        this.categories.get(index).setCategoryId(newId);
    }

    // Update category name
    public void updateCategoryName(int index, String newName) {
        this.categories.get(index).setCategoryName(newName);
    }

    // Update Product
    // Update product ID
    public void updateProductId(String productID, int index) {

        if (index >= 0 && index < categories.size()) {
            Product product = products.get(index);
            product.setProductID(productID);
        } else {
            System.out.println("Invalid index. Please provide a valid index.");
        }
    }

    // Update product name
    public boolean updateProductName(String newproductName, int index) {
        String oldProductsName = this.products.get(index).getProductName();
        this.products.get(index).setProductName(newproductName);
        for (int i = 0; i < this.categories.size(); i++) {
            ArrayList<Product> temProducts = (ArrayList<Product>) this.categories.get(i).getProducts();

            for (Product p : temProducts) {
                if (p.getProductName().equalsIgnoreCase(oldProductsName)) {
                    p.setProductName(newproductName);
                    return true;
                }
            }

        }

        return false;
    }

    // Update product Desc
    public boolean updateProductDesc(String newproductDescString, int index) {
        String oldProductsDesc = this.products.get(index).getProductDescription();
        this.products.get(index).setProductDescription(newproductDescString);
        for (int i = 0; i < this.categories.size(); i++) {
            ArrayList<Product> temProducts = (ArrayList<Product>) this.categories.get(i).getProducts();

            for (Product p : temProducts) {
                if (p.getProductDescription().equalsIgnoreCase(oldProductsDesc)) {
                    p.setProductDescription(newproductDescString);
                    return true;
                }
            }

        }

        return false;
    }

    // Update product price
    public boolean updateProductPrice(double newProductPrice, int index) {
        double oldProductPrice = this.products.get(index).getProductPrice();
        this.products.get(index).setProductPrice(newProductPrice);

        for (int i = 0; i < this.categories.size(); i++) {
            ArrayList<Product> tempProducts = (ArrayList<Product>) this.categories.get(i).getProducts();

            for (Product p : tempProducts) {
                if (p.getProductPrice() == oldProductPrice) {
                    p.setProductPrice(newProductPrice);
                    return true;
                }
            }
        }

        return false;
    }

    // Update product quantity
    public boolean updateProductQuantity(int newProductQuantity, int index) {
        int oldProductQuantity = this.products.get(index).getProductQuantity();
        this.products.get(index).setProductQuantity(newProductQuantity);

        for (int i = 0; i < this.categories.size(); i++) {
            ArrayList<Product> tempProducts = (ArrayList<Product>) this.categories.get(i).getProducts();

            for (Product p : tempProducts) {
                if (p.getProductQuantity() == oldProductQuantity) {
                    p.setProductQuantity(newProductQuantity);
                    return true;
                }
            }
        }

        return false;
    }

    public void displayAllCategories() {
        for (Category category : categories) {
            System.out.println("Category ID: " + category.getCategoryId());
            System.out.println("Category Name: " + category.getCategoryName());
            System.out.println("Category Description: " + category.getCategoryDescription());
            System.out.println("Number of Products: " + category.getProducts().size());
            System.out.println("-----------------------------");
        }
    }

    public void displayAllProducts() {
        for (Product product : products) {
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Description: " + product.getProductDescription());
            System.out.println("Product Price: " + product.getProductPrice());
            System.out.println("Product Quantity: " + product.getProductQuantity());
            System.out.println("-----------------------------");
        }
    }

    public void displayMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. View all categories");
        System.out.println("2. View products by category");
        System.out.println("3. View personal data");
        System.out.println("4. Update personal data");
        System.out.println("5. Exit");
        System.out.println("-----------------------------");
    }

    
}
