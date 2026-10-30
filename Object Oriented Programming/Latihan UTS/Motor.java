import java.util.*;

public class Motor extends Kendaraan{
    private int helm;

    public Motor(String plat, String merk, double harga, int helm){
        super(plat, merk, harga);
        this.helm = helm;
    }

    public int getHelm(){
        return helm;
    }

    public void setHelm(int helm){
        this.helm = helm;
    }

    public double hitungBiaya(int hari){
        if(this.helm > 1){
            return (this.harga * hari) + ((this.helm - 1) * 10000 * hari);
        }else{
            return super.hitungBiaya(hari);
        }
        
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Jumlah Helm: " + helm);
    }
}
