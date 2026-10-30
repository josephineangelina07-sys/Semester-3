import java.util.ArrayList;
import java.util.Scanner;

// Kelas Induk
class Visitor {
    protected String id;
    protected String name;
    protected double balance;
    protected ArrayList<String> visitHistory;
    protected int visitCount;

    public Visitor(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.visitHistory = new ArrayList<>();
        this.visitCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Method untuk melakukan transaksi kunjungan
    public boolean doVisit(int day) {
        // Biaya: Senin(1)-Kamis(4) = 10, Jumat(5)-Minggu(7) = 20
        double cost = (day >= 1 && day <= 4) ? 10 : 20; 
        
        if (this.balance < cost) {
            return false; // Saldo tidak cukup
        }
        
        this.balance -= cost;
        this.visitCount++;
        
        String[] dayNames = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String visitStr = "V" + this.visitCount + ". " + dayNames[day];
        // Menambahkan di index 0 agar riwayat tampil dari yang terbaru (reverse chronological)
        this.visitHistory.add(0, visitStr); 
        
        return true;
    }

    public void displayDetail() {
        System.out.println("Visitor: " + id + "/" + name);
        System.out.println("Balance: " + balance);
        System.out.println("Visiting history (by latest):");
        if (visitHistory.isEmpty()) {
            System.out.println("- No visit yet -");
        } else {
            for (String hist : visitHistory) {
                System.out.println(hist);
            }
        }
    }
}

// Kelas Anak (Inheritance)
class Member extends Visitor {
    private int pointReward;

    public Member(String id, String name, double balance) {
        super(id, name, balance);
        this.pointReward = 0;
    }

    // Overriding method visit untuk menambahkan logika point reward
    @Override
    public boolean doVisit(int day) {
        boolean success = super.doVisit(day);
        if (success) {
            this.pointReward += 1;
            // Konversi poin otomatis jika mencapai 10
            if (this.pointReward >= 10) {
                this.balance += 10;
                this.pointReward -= 10;
            }
        }
        return success;
    }

    @Override
    public void displayDetail() {
        System.out.println("Member: " + id + "/" + name);
        System.out.println("balance: " + balance);
        System.out.println("Point reward: " + pointReward);
        System.out.println("Visiting history (by latest):");
        if (visitHistory.isEmpty()) {
            System.out.println("- No visit yet -");
        } else {
            for (String hist : visitHistory) {
                System.out.println(hist);
            }
        }
    }
}

// Kelas Utama
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Visitor> visitors = new ArrayList<>();

        // Hardcoded Database sesuai spesifikasi soal
        visitors.add(new Visitor("c1", "Andi", 30));
        visitors.add(new Member("c2", "Anto", 20));
        visitors.add(new Member("c3", "Meli", 30));
        visitors.add(new Member("c4", "Bobby", 40));

        int menu = 0;
        
        while (menu != 3) {
            System.out.println("\nVisitor Application");
            System.out.println("=======================");
            System.out.println("1. New Visit");
            System.out.println("2. View Visitor Detail");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            
            try {
                menu = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                menu = 0;
            }

            if (menu == 1) {
                System.out.print("Input Visitor ID: ");
                String searchId = scan.nextLine();
                
                Visitor currentVisitor = null;
                for (Visitor v : visitors) {
                    if (v.getId().equalsIgnoreCase(searchId)) {
                        currentVisitor = v;
                        break;
                    }
                }

                if (currentVisitor == null) {
                    System.out.println("Visitor ID not found");
                } else {
                    System.out.print("Input day (1-7): ");
                    int day = 0;
                    try {
                        day = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        day = 0;
                    }

                    if (day >= 1 && day <= 7) {
                        boolean isSuccess = currentVisitor.doVisit(day);
                        if (isSuccess) {
                            System.out.println("Welcome " + currentVisitor.getName());
                        } else {
                            System.out.println("Insufficient fund for " + currentVisitor.getName());
                        }
                    } else {
                        System.out.println("Invalid day input.");
                    }
                }

            } else if (menu == 2) {
                System.out.println("---");
                for (int i = 0; i < visitors.size(); i++) {
                    Visitor v = visitors.get(i);
                    // Pengecekan polymorphism dengan instanceof sesuai kriteria
                    if (v instanceof Member) {
                        Member m = (Member) v; // Casting ke kelas sebenarnya
                        m.displayDetail();
                    } else {
                        v.displayDetail();
                    }
                    if (i < visitors.size() - 1) {
                        System.out.println("---");
                    }
                }
            } else if (menu == 3) {
                break;
            } else {
                System.out.println("Invalid Menu.");
            }
        }
        scan.close();
    }
}