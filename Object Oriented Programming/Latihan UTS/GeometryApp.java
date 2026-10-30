import java.util.Scanner;

public class GeometryApp {
    public static void main(String[] args){
        int menu = 0;
        while(menu != 2){
            System.out.println("MENU");
            System.out.println("1. Calculate Circle Area");
            System.out.println("2. Exit");
            System.out.print("Choose: ");

            Scanner input = new Scanner(System.in);
            menu = input.nextInt();
            if (menu == 1){
                System.out.print("Enter the radius: ");
                double radius = input.nextDouble();
                Circle CircleArea = new Circle(radius);
                System.out.println("The area of the circle is " + CircleArea.calculateArea() + " cm");
            }else if(menu == 2){
                break;
            }else{
                System.out.println("Invalid menu");
            }
        }
    }
}
