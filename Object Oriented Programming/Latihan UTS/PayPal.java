public class PayPal extends Payment{
    private String email;

    public PayPal(double amount, String email){
        super(amount);
        this.email = email;
    }

    public void processPayment(){
        System.out.println("PayPal funds deducted from " + email + ": $" + getAmount());
    }
}
