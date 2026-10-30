public class Buku {
    private String judul;
    private String penulis;
    private int hargaSewa;

    public Buku(String judul, String penulis, int hargaSewa){
        this.judul = judul;
        this.penulis = penulis;
        this.hargaSewa = hargaSewa;
    }

    public String getJudul(){
        return judul;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }

    public String getPenulis(){
        return penulis;
    }

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }

    public int getHargaSewa(){
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa){
        this.hargaSewa = hargaSewa;
    }
}
