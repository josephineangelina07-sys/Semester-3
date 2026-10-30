package oopmid;

import java.util.Scanner;
import java.util.ArrayList;

public class Program2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Visitor2> visitors = new ArrayList<>();

        visitors.add(new Visitor2("c1", "Andi", 30));
        visitors.add(new Visitor2("c2", "Anto", 20));
        visitors.add(new Visitor2("c3", "Meli", 30));
        visitors.add(new Visitor2("c4", "Bobby", 40));

        int menu = 0;
        while(menu != 3){
            System.out.println("\nMENU");
            System.out.println("1. New Visit");
            System.out.println("2. View Visitor Detail");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            menu = input.nextInt();
            input.nextLine();

            if(menu == 1){
                System.out.print("Input Visitor ID: ");
                String id = input.nextLine();

                Visitor2 currentVisitor = null;
                for(Visitor2 v : visitors){
                    if(v.getId().equalsIgnoreCase(id)){
                        currentVisitor = v;
                        break;
                    }
                }

                if(currentVisitor == null){
                    System.out.println("Visitor ID not found");
                }else{
                    System.out.print("Input day (1-7): ");
                    int day = input.nextInt();

                    if(day >= 1 && day <= 7){
                        boolean isSuccess = currentVisitor.doVisit(day);
                        if(isSuccess){
                            System.out.println("Welcome " + currentVisitor.getname());
                        }else{
                            System.out.println("Insufficient fund");
                        }
                    }else{
                        System.out.println("Invalid days");
                    }
                }
            }else if(menu == 2){
                for(int i = 0; i<visitors.size(); i++){
                    Visitor2 v = visitors.get(i);
                    if (v instanceof Member2){
                        Member2 m = (Member2) v;
                        m.displayDetail();
                    }else{
                        v.displayDetail();
                    }
                }
            }else if(menu == 3){
                break;
            }else{
                System.out.println("Invalid menu");
            }
        }
    }
}
