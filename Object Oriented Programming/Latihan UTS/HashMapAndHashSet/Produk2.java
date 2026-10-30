package HashMapAndHashSet;

public class Produk2 {
    private String kodeProduk;
    private String nama;
    private String kategori;
    private int stok;
    private double harga;

    public Produk2(String kodeProduk, String nama, String kategori, int stok, double harga){
        this.kodeProduk = kodeProduk;
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public String getKodeProduk(){
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk){
        this.kodeProduk = kodeProduk;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getKategori(){
        return kategori;
    }

    public void setKategori(String kategString){
        this.kategori = kategori;
    }

    public int getStok(){
        return stok;
    }

    public void setStok(int stock){
        this.stok = stok;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public void displayInfo(){
        System.out.println("Kode Produk : " + kodeProduk);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Kategori    : " + kategori);
        System.out.println("Stok        : " + stok);
        System.out.println("Harga       : Rp" + harga);
        System.out.println("----------------------------------");
    }
}
