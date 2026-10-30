import java.util.Scanner;

public class CoffeeController {
    public static void main(String[] args){
        int menu = 0;
        while(menu != 4){
            System.out.println("\nMenu:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Check Water");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            Scanner input = new Scanner(System.in);
            menu =  input.nextInt();

            if(menu == 1){
                System.out.println("Brewing Espresso");
            }else if(menu == 2){
                System.out.println("Brewing Latte");
            }else if(menu == 3){
                System.out.println("Water level is adequate.");
            }else if(menu == 4){
                break;
            }else{
                System.out.println("Invalid menu");
            }
        }
    }
}
