import java.util.*;

public class EasyBuku {
    public static void main(String[] args){
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int menu = 0;

        while(menu != 5){
            System.out.println("\nMENU");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Ubah Harga Sewa");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            menu = input.nextInt();
            input.nextLine();

            if(menu == 1){
                System.out.print("Masukkan Judul Buku: ");
                String judul = input.nextLine();
                System.out.print("Masukkan Penulis Buku: ");
                String penulis = input.nextLine();
                System.out.print("Masukkan Harga Sewa: ");
                int hargaSewa = input.nextInt();

                daftarBuku.add(new Buku(judul, penulis, hargaSewa));
                System.out.println("Buku berhasil ditambahkan!");
            }else if(menu == 2){
                if(daftarBuku.isEmpty()){
                    System.out.println("Daftar Buku Masih Kosong!");
                }else{
                    for(int i = 0; i<daftarBuku.size(); i++){
                        System.out.println("\n--- Daftar Buku ---");
                        Buku b = daftarBuku.get(i);
                        System.out.println((i+1) + "." + "Buku: " + b.getJudul() + " - Penulis: " + b.getPenulis() + " - Harga Sewa: " + b.getHargaSewa());
                    }
                }
            }else if(menu == 3){
                if(daftarBuku.isEmpty()){
                    System.out.println("Daftar Buku Masih Kosong!");
                }else{
                    System.out.print("Masukkan nomor urut buku yang ingin diubah harga sewanya ");
                    int idx = input.nextInt() - 1;
                    if(idx >= 0 && idx <= daftarBuku.size()){
                        System.out.print("Masukkan Harga Sewa Baru: ");
                        int newHargaSewa = input.nextInt();
                        daftarBuku.get(idx).setHargaSewa(newHargaSewa);
                        System.out.println("Harga Sewa Berhasil Diperbaharui!");
                    }else{
                        System.out.println("Nomor invalid!");
                    }
                }
            }else if(menu == 4){
                if(daftarBuku.isEmpty()){
                    System.out.println("Daftar Buku Masih Kosong!");
                }else{
                    System.out.print("Masukkan nomor urut buku yang ingin dihapus: ");
                    int idx = input.nextInt() - 1;
                    if(idx >= 0 && idx <= daftarBuku.size()){
                        daftarBuku.remove(idx);
                        System.out.println("Buku berhasil dihapus!");
                    }else{
                        System.out.println("Nomor invalid");
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
