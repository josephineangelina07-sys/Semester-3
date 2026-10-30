import java.util.Scanner;

public class TheLibraryGreeter {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Fullname: ");
        String name = input.nextLine();
        System.out.print("Registration Year: ");
        int year = input.nextInt();
        System.out.println("Hello " + name + ", you have been a member for " + (2025-year) + " years");
    }
}