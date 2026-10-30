package oopmid;

import java.util.*;

public class Visitor2 {
    protected String id;
    protected String name;
    protected double balance;
    protected ArrayList<String> visitorHistory;
    protected int visitCount;

    public Visitor2(String id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.visitorHistory = new ArrayList<>();
        this.visitCount = 0;
    }

    public String getId(){
        return id;
    }

    public String getname(){
        return name;
    }

    public boolean doVisit(int day){
        double cost;
        if(day >= 1 && day <= 4){
            cost = 10;
        }else{
            cost = 20;
        }

        if(this.balance < cost){
            return false;
        }

        this.balance -= cost;
        this.visitCount++;

        String dayNames[] = {"Modany", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String visitStr = "V" + this.visitCount + ". " + dayNames[day];
        this.visitorHistory.add(0, visitStr);

        return true;
    }

    public void displayDetail(){
        System.out.println("Visitor: " + id + "/" + name);
        System.out.println("Balance: " + balance);
        System.out.println("Visiting history (by latest):");
        if (visitorHistory.isEmpty()) {
            System.out.println("- No visit yet -");
        } else {
            for (String hist : visitorHistory) {
                System.out.println(hist);
            }
        }
    }
}
