public class CreditCard extends Payment {
    private String cardNumber;
    public CreditCard(double amount, String cardNumber){
        super(amount);
        this.cardNumber = cardNumber;
    }

    public void processPayment(){
        System.out.println("Card " + cardNumber + " processed for $" + getAmount());
    }
}
