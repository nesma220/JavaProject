import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MerchantApp {

    private static List<Product> productList = new ArrayList<>();
    private static List<Category> categoryList = new ArrayList<>();
    private static List<Invoice> invoiceList = new ArrayList<>();
    public static Customer customer = new Customer();

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("*** Login Page ***");
            System.out.println("1- Login as admin");
            System.out.println("2- Login as customer");
            System.out.println("3- Exite Program");
            System.out.print("Enter youre choice: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("==============");
                loginAsAdmin();
            } else if (choice == 2) {
                System.out.println("==============");
                loginAsCustomer();
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Wrong input..!!!");
            }
        }
    }

    public static void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the user is a merchant
        if (isMerchant(email, password)) {
            System.out.println("Merchant login successful!");
            // Perform merchant operations
            merchantMenu();
        } else {
            System.out.println("Invalid email or password. Please try again.");
            System.out.println("==============");
        }
    }

    public static void loginAsCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the user is a buyer
        if (isBuyer(email, password)) {
            System.out.println("Buyer login successful!");
            // Perform buyer operations
            buyerMenu();
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }

    public static boolean isBuyer(String email, String password) {
        // Check if the email and password match the buyer's credentials
        return email.equals(customer.getName()) && password.equals(customer.getPassword());
    }

    public static boolean isMerchant(String email, String password) {
        // Check if the email and password match the merchant's credentials
        return email.equals("merchant@example.com") && password.equals("merchant123");
    }

    public static void buyerMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("==============");
            System.out.println("Buyer Main Menu");
            System.out.println("1. Display All Categories");
            System.out.println("2. Display All Products Of Category");
            System.out.println("3. Display Personal Information");
            System.out.println("4. Update Personal Information");
            System.out.println("5. Buy Product");
            System.out.println("6. View All Invoices");
            System.out.println("7. Exite From Customer Screen");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewAllCategories();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    System.out.println("==============");
                    System.out.println(customer.toString());
                    break;
                case 4:
                    System.out.print("Enter new name: ");
                    input.nextLine();
                    customer.setName(input.nextLine());
                    System.out.print("Enter new password: ");
                    customer.setPassword(input.nextLine());
                    System.out.print("Enter new birthdate: ");
                    customer.setBirthDate(input.nextLine());
                    break;
                case 5:
                    buyProduct();

                    break;
                case 6:
                    viewAllInvoices();
                    break;
                case 7:
                    System.out.println("==============");
                    return;
                default:
                    System.out.println("Wrong input..!!!");
                    break;
            }
        }
    }

    public static void merchantMenu() {
        System.out.println("==============");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Merchant Menu:");
            System.out.println("1. Add Categories");
            System.out.println("2. Add Products");
            System.out.println("3. Edit Categories");
            System.out.println("4. Edit Products");
            System.out.println("5. View All Categories");
            System.out.println("6. View All Products");
            System.out.println("7. View All Invoices");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCategories();
                    break;
                case 2:
                    addProducts();
                    break;
                case 3:
                    editCategories();
                    break;
                case 4:
                    editProducts();
                    break;
                case 5:
                    viewAllCategories();
                    break;
                case 6:
                    viewAllProducts();
                    break;
                case 7:
                    viewAllInvoices();
                    break;
                case 8:
                    System.out.println("Merchant logout successful!");
                    System.out.println("==============");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("==============");
        }
    }

    // public static void addProducts() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Add Products");
    //     System.out.print("Enter product ID: ");
    //     String productID = scanner.nextLine();
    //     System.out.print("Enter product name: ");
    //     String productName = scanner.nextLine();
    //     System.out.print("Enter product description: ");
    //     String productDescription = scanner.nextLine();
    //     System.out.print("Enter product price: ");
    //     double productPrice = scanner.nextDouble();
    //     System.out.print("Enter product quantity: ");
    //     int productQuantity = scanner.nextInt();
    //     scanner.nextLine();
    //     Product product = new Product(productID, productName, productDescription, productPrice, productQuantity);
    //     productList.add(product);
    //     System.out.println("Product added successfully!");
    // }

    
    public static void addProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Products");

        if (categoryList.isEmpty()) {
            System.out.println("No categories available. Please add categories first.");
            return;
        }

        // Display available categories
        System.out.println("Available Categories:");
        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);
            System.out.println((i + 1) + ". " + category.getCategoryName());
        }

        // Choose a category
        System.out.print("Enter the category number: ");
        int categoryNumber = scanner.nextInt();
        scanner.nextLine();

        if (categoryNumber < 1 || categoryNumber > categoryList.size()) {
            System.out.println("Invalid category number. Please try again.");
            return;
        }

        Category selectedCategory = categoryList.get(categoryNumber - 1);

        // Get product details
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product description: ");
        String productDescription = scanner.nextLine();

        double productPrice = 0.0;
        while (true) {
            System.out.print("Enter product price: ");
            String priceStr = scanner.nextLine();
            try {
                productPrice = Double.parseDouble(priceStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }

        int productQuantity = 0;
        while (true) {
            System.out.print("Enter product quantity: ");
            String quantityStr = scanner.nextLine();
            try {
                productQuantity = Integer.parseInt(quantityStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid quantity.");
            }
        }

        System.out.print("Enter product colors (comma-separated): ");
        String colorsStr = scanner.nextLine();
        String[] productColors = colorsStr.split(",");

        // Create a list to store the colors
        List<String> colorsList = new ArrayList<>();
        for (String color : productColors) {
            colorsList.add(color.trim());
        }

        Product product = new Product(productID, productName, productDescription, productPrice, productQuantity);
        product.setColors(colorsList);

        selectedCategory.getProducts().add(product);

        System.out.println("Product added successfully to the category: " + selectedCategory.getCategoryName());
    }



    public static void editProducts() {
        System.out.println("==============");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit Products");

        System.out.print("Enter product ID to edit: ");
        String productID = scanner.nextLine();

        Product product = findProductByID(productID);
        if (product != null) {
            System.out.println("Product found: " + product.getProductName());
            System.out.print("Enter new product name: ");
            String newName = scanner.nextLine();
            product.setProductName(newName);

            System.out.print("Enter new product description: ");
            String newDescription = scanner.nextLine();
            product.setProductDescription(newDescription);

            System.out.print("Enter new product price: ");
            double newPrice = scanner.nextDouble();
            product.setProductPrice(newPrice);

            System.out.print("Enter new product quantity: ");
            int newQuantity = scanner.nextInt();
            product.setProductQuantity(newQuantity);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public static void addCategories() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Categories");

        System.out.print("Enter category ID: ");
        String categoryID = scanner.nextLine();

        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine();

        System.out.print("Enter category description: ");
        String categoryDescription = scanner.nextLine();

        Category category = new Category(categoryID, categoryName, categoryDescription, new ArrayList<>(), 0);
        categoryList.add(category);

        System.out.println("Category added successfully!");
    }

    public static void editCategories() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit Categories");

        System.out.print("Enter category ID to edit: ");
        String categoryID = scanner.nextLine();

        Category category = findCategoryByID(categoryID);
        if (category != null) {
            System.out.println("Category found: " + category.getCategoryName());

            System.out.print("Enter new category name: ");
            String newName = scanner.nextLine();
            category.setCategoryName(newName);

            System.out.print("Enter new category description: ");
            String newDescription = scanner.nextLine();
            category.setCategoryDescription(newDescription);

            System.out.println("Category updated successfully!");
        } else {
            System.out.println("Category not found!");
        }
    }

    public static void viewAllCategories() {
        System.out.println("==============");
        System.out.println("View All Categories");
        if (categoryList.isEmpty()) {
            System.out.println("No categories available!");
        } else {
            for (Category category : categoryList) {
                System.out.println("Category ID: " + category.getCategoryId());
                System.out.println("Category Name: " + category.getCategoryName());
                System.out.println("Category Description: " + category.getCategoryDescription());
                System.out.println("Number of Products: " + category.getProducts().size());
                System.out.println();
            }
        }
    }

    public static void viewAllProductsOfCategory(int index) {
        System.out.println("==============");
        List<Product> tempProducts = categoryList.get(index).getProducts();
        for (Product p : tempProducts) {
            System.out.println(p.toString());
        }
    }

    public static void viewAllProducts() {
        System.out.println("==============");
        System.out.println("View All Products");

        if (categoryList.isEmpty()) {
            System.out.println("No categories available!");
        } else {
            for (Category category : categoryList) {
                System.out.println("Category Name: " + category.getCategoryName());
                System.out.println("Number of Products: " + category.getProducts().size());

                List<Product> products = category.getProducts();
                if (products.isEmpty()) {
                    System.out.println("No products available in this category.");
                } else {
                    for (Product product : products) {
                        System.out.println("Product ID: " + product.getProductID());
                        System.out.println("Product Name: " + product.getProductName());
                        System.out.println("Product Description: " + product.getProductDescription());
                        System.out.println("Product Price: " + product.getProductPrice());
                        System.out.println("Product Quantity: " + product.getProductQuantity());
                        System.out.println("Product Colors: " + String.join(", ", product.getColors()));
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void viewAllInvoices() {
        System.out.println("==============");
        System.out.println("View All Invoices");

        if (invoiceList.isEmpty()) {
            System.out.println("No invoices available!");
        } else {
            for (Invoice invoice : invoiceList) {
                System.out.println("Invoice ID: " + invoice.getInvoiceID());
                System.out.println("Customer Name: " + invoice.getCustomerName());
                System.out.println("Invoice Date: " + invoice.getInvoiceDate());
                System.out.println("Total Amount: " + invoice.getTotalAmount());
                System.out.println();
            }
        }
    }

    public static Product findProductByID(String productID) {
        for (Category category : categoryList) {
            for (Product product : category.getProducts()) {
                if (product.getProductID().equals(productID)) {
                    return product;
                }
            }
        }
        return null;
    }

    private static Category findCategoryByID(String categoryID) {
        for (Category category : categoryList) {
            if (category.getCategoryId().equals(categoryID)) {
                return category;
            }
        }
        return null;
    }

    public static void buyProduct() {
        Scanner input = new Scanner(System.in);

        // Display available categories
        viewAllCategories();

        System.out.print("Enter the category number: ");
        int categoryNumber = input.nextInt();
        input.nextLine();

        if (categoryNumber < 1 || categoryNumber > categoryList.size()) {
            System.out.println("Invalid category number. Please try again.");
            return;
        }

        Category selectedCategory = categoryList.get(categoryNumber - 1);

        // Display products in the selected category
        viewAllProductsOfCategory(categoryNumber - 1);

        System.out.print("Enter the product number: ");
        int productNumber = input.nextInt();
        input.nextLine();

        if (productNumber < 1 || productNumber > selectedCategory.getProducts().size()) {
            System.out.println("Invalid product number. Please try again.");
            return;
        }

        Product selectedProduct = selectedCategory.getProducts().get(productNumber - 1);

        System.out.print("Enter the quantity: ");
        int quantity = input.nextInt();

        // Check if the requested quantity is available
        if (quantity > selectedProduct.getProductQuantity()) {
            System.out.println("Insufficient quantity. Please try again.");
            return;
        }

        // Create a cart item and add it to the customer's cart
        CartItem cartItem = new CartItem(selectedProduct.getProductName(), selectedProduct.getProductPrice(), quantity);
        customer.getCart().add(cartItem);

        System.out.println("Product added to the cart successfully!");
    }

}
