import java.util.Scanner;

public class InventoryApp {
    public static void main(String[] args){
        Product laptop = new Product("Laptop", 500.0, 10);
        int menu = 0;
        while(menu != 4){
            System.out.println("\n MENU");
            System.out.println("1. View Details");
            System.out.println("2. Update Price");
            System.out.println("3. Update Stock");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            Scanner input = new Scanner(System.in);
            menu = input.nextInt();

            if(menu == 1){
                System.out.println(laptop.toString());
            }else if(menu == 2){
                System.out.println("Enter new price: ");
                double newPrice = input.nextDouble();
                laptop.setPrice(newPrice);
            }else if(menu == 3){
                System.out.println("Enter updated stock: ");
                int newStock = input.nextInt();
                laptop.setStock(newStock);
            }else if(menu == 4){
                break;
            }else{
                System.out.println("Invalid menu");
            }
        }
    }
}
