import java.util.Scanner;

public class TerminalApp {
    public static void main(String[] args){
        int menu = 0;
        Scanner input = new Scanner(System.in);
        while(menu != 3){
            System.out.println("MENU");
            System.out.println("1. Pay via Credit Card");
            System.out.println("2. Pay via PayPal");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            menu = Integer.parseInt(input.nextLine());

            Payment paymentMethod = null;

            if(menu == 1){
                System.out.print("Enter Card Number: ");
                String cardNumber = input.nextLine();
                System.out.print("Enter Amount: $");
                double amount = Double.parseDouble(input.nextLine());
                paymentMethod = new CreditCard(amount, cardNumber);
            }else if(menu == 2){
                System.out.print("Enter PayPal Email: ");
                String email = input.nextLine();
                System.out.print("Enter Amount: $");
                double amount = Double.parseDouble(input.nextLine());
                paymentMethod = new PayPal(amount, email);
            }else if(menu == 3){
                break;
            }else{
                System.out.println("Invalid input");
                continue;
            }

            System.out.println("Processing: ");
            paymentMethod.processPayment();
        }
    }
}
