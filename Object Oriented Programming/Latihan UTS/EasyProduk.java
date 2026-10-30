import java.util.*;

public class EasyProduk {
    public static void main(String[] args){
        int menu = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();
        while(menu != 5){
            System.out.println("\nMENU");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Daftar Produk");
            System.out.println("3. Ubah Harga Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            menu = input.nextInt();
            input.nextLine();

            if(menu == 1){
                System.out.print("Masukkan nama produk: ");
                String nama = input.nextLine();
                System.out.print("Masukkan harga produk: ");
                int harga = input.nextInt();

                daftarProduk.add(new Produk(nama, harga));
                System.out.println("Produk berhasil ditambahkan!");
            }else if(menu == 2){
                if(daftarProduk.isEmpty()){
                    System.out.println("Daftar produk masih kosong");
                }else{
                    System.out.println("\n--- Daftar Produk ---");
                    for(int i = 0; i<daftarProduk.size(); i++){
                        Produk p = daftarProduk.get(i);
                        System.out.println((i+1) + "." + p.getNama() + " - Rp" + p.getHarga());
                    }
                }
            }else if(menu == 3){
                if(daftarProduk.isEmpty()){
                    System.out.println("Daftar Produk Masih Kosong!");
                }else{
                    System.out.print("Masukkan nomor urut produk yang ingin diubah harganya: ");
                    int idx = input.nextInt() - 1;

                    if(idx >= 0 && idx <= daftarProduk.size()){
                        System.out.print("Masukkan harga baru: ");
                        int newHarga = input.nextInt();
                        daftarProduk.get(idx).setHarga(newHarga);
                        System.out.println("Harga sudah diperbaharui!");
                    }else{
                        System.out.println("Nomor tidak valid");
                    }
                }
            }else if(menu == 4){
                if(daftarProduk.isEmpty()){
                    System.out.println("Daftar Produk Masih Kosong!");
                }else{
                    System.out.print("Masukkan nomor urut produk yang ingin dihapus: ");
                    int idx = input.nextInt() - 1;

                    if(idx >= 0 && idx <= daftarProduk.size()){
                        daftarProduk.remove(idx);
                        System.out.println("Produk berhasil dihapus!");
                    }else{
                        System.out.println("Nomor tidak valid");
                    }
                }
            }else if(menu == 5){
                break;
            }else{
                System.out.println("Invalid menu!");
            }
        }
    }
}
