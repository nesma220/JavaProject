
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class Invoice {

    private String invoiceID;
    private String customerName;
    private LocalDateTime invoiceDate;
    private double totalAmount;





    public Invoice(String invoiceID, String customerName, LocalDateTime invoiceDate, double totalAmount) {
        this.invoiceID = invoiceID;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
    }

    Invoice() {
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }



}
