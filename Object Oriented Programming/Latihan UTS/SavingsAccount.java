public class SavingsAccount extends BankAccount {
    private double interestrate;

    public SavingsAccount(double balance, double interestrate){
        super(balance);
        this.interestrate = interestrate;
    }

    public void applyInterest(){
        double interestAmount = getBalance() * interestrate;
        deposit(interestAmount);
    }
}
