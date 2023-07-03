import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String password;
    private String birthDate;
    ArrayList<Product> invoces;
    private List<CartItem> cart;


    public Customer () {
        this.name = "buyer@example.com";
        this.password = "buyer123";
        this.birthDate = "17/03/2002";
        this.invoces = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public Customer(String name, String password, String birthDate) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.invoces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String displayInvoices() {
        String result = "";
        for (Product prouct : this.invoces) {
            result += prouct.toString() + "\n======================\n";
        }
        return (result.equals("")) ? "empty" : result;
    }

    public void addToInvoice(Product product) {
        invoces.add(product);
    }
    
    @Override
    public String toString(){
        return "Name: " + this.getName() + "\nPassword: " + this.getPassword() 
                + "\nBirthdate: " + this.getBirthDate() + "\nInvoces: " + this.displayInvoices();
    }


    public List<CartItem> getCart() {
        return cart;
    }
    public void removeFromCart(CartItem item) {
        cart.remove(item);
    }

}
