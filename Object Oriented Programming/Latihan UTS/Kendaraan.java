import java.util.ArrayList;

public class Kendaraan {
    protected String plat;
    protected String merk;
    protected double harga;
    protected ArrayList<String> rentHistory;

    public Kendaraan(String plat, String merk, double harga){
        this.plat = plat;
        this.merk = merk;
        this.harga = harga;
        this.rentHistory = new ArrayList<>();
    }

    public String getPlat(){
        return plat;
    }

    public void setPlat(String plat){
        this.plat = plat;
    }

    public String getMerk(){
        return merk;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public double getHarga(){
        return harga;
    }

    public ArrayList<String> getRentHistory(){
        return rentHistory;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public double hitungBiaya(int hari){
        return this.harga * hari;
    }

    public void tambahRiwayat(String catatan){
        this.rentHistory.add(0, catatan);
    }

    public void displayInfo(){
        System.out.println("Plat Nomor  : " + plat);
        System.out.println("Merk        : " + merk);
        System.out.println("Harga/hari  : Rp" + harga);
        System.out.println("Riwayat Sewa:");
        if(rentHistory.isEmpty()){
            System.out.println(" - Belum ada riwayat sewa -");
        }else{
            for(String r : rentHistory){
                System.out.println("* " + r);
            }
        }
    }
}
