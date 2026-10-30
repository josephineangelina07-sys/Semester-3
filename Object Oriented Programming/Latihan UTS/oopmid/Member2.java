package oopmid;

public class Member2 extends Visitor2{
    private int pointReward;

    public Member2(String id, String name, double balance){
        super(id, name, balance);
        this.pointReward = 0;
    }

    public boolean doVisit(int day){
        boolean success = super.doVisit(day);
        if(success){
            this.pointReward += 1;

            if(this.pointReward >= 10){
                this.balance += 10;
                this.pointReward -= 10;
            }
        }
        return success;
    }

    public void displayDetail(){
        System.out.println("Member: " + id + "/" + name);
        System.out.println("balance: " + balance);
        System.out.println("Point reward: " + pointReward);
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
