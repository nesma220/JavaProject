


import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Create an instance of the Store
        Store store = new Store();

        // Add categories
        Category category1 = new Category("1", "Category 1", "Category 1 description", new ArrayList<>(), 0);
        Category category2 = new Category("2", "Category 2", "Category 2 description", new ArrayList<>(), 0);
        store.addCategory(category1);
        store.addCategory(category2);

        // Add products
        Product product1 = new Product("1", "Product 1", "Product 1 description", 10.99, 5);
        Product product2 = new Product("2", "Product 2", "Product 2 description", 19.99, 3);
        store.addProduct(product1);
        store.addProduct(product2);

        // Add product to category
        store.addtoCategory("1", product1);
        store.addtoCategory("2", product2);

        // Display all categories
        store.displayAllCategories();

        // Update category ID
        store.updateCategoryId(0, "newCategoryId");

        // Update category name
        store.updateCategoryName(1, "New Category Name");

        // Display all categories after updates
        store.displayAllCategories();

        store.addProduct(product1);

        Customer customer = new Customer("nesma", "123", "12");
        customer.addToInvoice(product1);
      customer.addToInvoice(product2);



    }

}
