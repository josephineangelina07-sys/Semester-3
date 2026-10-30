import java.util.*;

public class Mobil extends Kendaraan{
    private boolean sopir;
    private double sewaSopir;

    public Mobil(String plat, String merk, double harga, boolean sopir, double sewaSopir){
        super(plat, merk, harga);
        this.sopir = sopir;
        this.sewaSopir = sewaSopir;
    }

    public boolean isSopir(){
        return sopir;
    }

    public void setSopir(boolean sopir){
        this.sopir = sopir;
    }

    public double getSewaSopir(){
        return sewaSopir;
    }

    public void setSewaSopir(double sewaSopir){
        this.sewaSopir = sewaSopir;
    }

    public double hitungBiaya(int hari){
        if(this.sopir){
            return (this.harga * this.sewaSopir) * hari;
        }else{
            return super.hitungBiaya(hari);
        }
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Pakai Sopir : " + (sopir ? "Ya" : "Tidak"));
        if(sopir){
            System.out.println("Biaya Sopir : Rp" + sewaSopir + "/hari");
        }
    }
}
