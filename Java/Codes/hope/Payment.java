
public class Payment {
    private int paymentId;
    private int applicationId;
    private double amount;
    private String paymentDate;
    private String paymentStatus;

    public Payment(int paymentId, int applicationId, double amount, String paymentDate) {
        this.paymentId = paymentId;
        this.applicationId = applicationId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = "Pending";
    }

    public void makePayment() {
        // Simulate payment process
        this.paymentStatus = "Completed";
        System.out.println("Payment made successfully for Application ID: " + applicationId);
    }

    public void getPaymentStatus() {
        // Display payment status
        System.out.println("Payment Status: " + paymentStatus);
    }

    public void generateReceipt() {
        // Logic to generate payment receipt
        System.out.println("Receipt generated for Payment ID: " + paymentId);
    }
}
