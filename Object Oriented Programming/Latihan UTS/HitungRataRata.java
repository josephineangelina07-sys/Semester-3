import java.util.Scanner;

public class HitungRataRata {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double waktu1 = input.nextDouble();
        double waktu2 = input.nextDouble();
        double waktu3 = input.nextDouble();

        double rataRata = (waktu1+waktu2+waktu3)/3;
        if(rataRata < 10){
            System.out.println("Luar Biasa!");
        }else{
            System.out.println("Terus Latihan!");
        }
        //input.close;
    }
}