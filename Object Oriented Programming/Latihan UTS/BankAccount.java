public class BankAccount {
    private double balance;
    
    public BankAccount(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        }else{
            System.out.println("Invalid deposit amount!");
        }
    }

    public double getBalance(){
        return balance;
    }
}
