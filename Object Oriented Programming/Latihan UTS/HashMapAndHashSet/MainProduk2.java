package HashMapAndHashSet;

import java.util.*;

public class MainProduk2 {
    public static void main(String[] args){
        HashMap<String, Produk2> inventaris = new HashMap<>();
        HashSet<String> daftarKategori = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int menu = 0;

        while(menu != 5){
            System.out.println("\nMENU");
            System.out.println("1. Tambah Produk Baru");
            System.out.println("2. Lihat / Cari Produk");
            System.out.println("3. Ubah Stok & Harga");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            menu = input.nextInt();
            input.nextLine();

            if(menu == 1){
                System.out.println("\n--- Tambah Produk Baru ---");
                System.out.print("Masukkan Kode Produk (SKU): ");
                String kode = input.nextLine();

                if(inventaris.containsKey(kode)){
                    System.out.println("ERROR");
                }else{
                    System.out.print("Masukkan Nama Produk: ");
                    String nama = input.nextLine();
                    System.out.println("Masukkan Kategori: ");
                    String kategori = input.nextLine();
                    System.out.println("Masukkan Jumlah Stok: ");
                    int stok = input.nextInt();
                    System.out.println("Masukkan Harga Produk: ");
                    double harga = input.nextDouble();
                    
                    Produk2 produkBaru = new Produk2(kode, nama, kategori, stok, harga);
                    inventaris.put(kode, produkBaru);
                    daftarKategori.add(kategori);
                    System.out.println("SUCCESS: Produk berhasil ditambahkan!");
                }
            }else if(menu == 2){
                if(inventaris.isEmpty()){
                    System.out.println("Inventaris masih kosong");
                }else{
                    System.out.println("\n--- Menu Lihat / Cari Produk ---");
                    System.out.println("a. Lihat Semua Produk & Kategori Unik");
                    System.out.println("b. Cari Produk Berdasarkan Kode");
                    System.out.print("Pilih (a/b): ");
                    String pilihan = input.nextLine();

                    if(pilihan.equalsIgnoreCase("a")){
                        System.out.println("\n--- Daftar Seluruh Produk ---");
                        for (Produk2 p : inventaris.values()){
                            p.displayInfo();
                        }

                        System.out.println("\n--- Kategori Unik Terdaftar");
                        for(String kat : daftarKategori){
                            System.out.println("- " + kat);
                        }
                    }else if(pilihan.equalsIgnoreCase("b")){
                        System.out.println("Masukkan Kode Produk yang dicari: ");
                        String kodeCari = input.nextLine();

                        Produk2 p = inventaris.get(kodeCari);
                        if(p != null){
                            System.out.println("\n--- Detail Produk Ditemukan!");
                            p.displayInfo();
                        }else{
                            System.out.println("Produk tidak ditemukan");
                        }
                    }else{
                        System.out.println("Pilihan invalid");
                    }
                }
            }else if(menu == 3){
                if(inventaris.isEmpty()){
                    System.out.println("Inventaris masih kosong");
                }else{
                    System.out.println("\n--- Ubah Stok & Harga Produk ---");
                    System.out.print("Masukkan Kode Produk yang ingin diperbarui: ");
                    String kodeUbah = input.nextLine();

                    if(inventaris.containsKey(kodeUbah)){
                        Produk2 p = inventaris.get(kodeUbah);
                        System.out.print("Data Produk Saat Ini: ");
                        p.displayInfo();

                        System.out.print("Masukkan Stok Baru: ");
                        int stokBaru = input.nextInt();
                        System.out.print("Masukkan Harga Baru: ");
                        double hargaBaru = input.nextDouble();

                        p.setStok(stokBaru);
                        p.setHarga(hargaBaru);
                        System.out.println("SUCCESS: Data produk berhasil diperbarui!");
                    }else{
                        System.out.println("Produk tidak ditemukan!");
                    }
                }
            }else if(menu == 4){
                if(inventaris.isEmpty()){
                    System.out.println("Inventaris masih kosong");
                }else{
                    System.out.println("\n--- Hapus Produk ---");
                    System.out.print("Masukkan Kode Produk yang ingin dihapus: ");
                    String kodeHapus = input.nextLine();

                    if(inventaris.containsKey(kodeHapus)){
                        inventaris.remove(kodeHapus);
                        System.out.println("Produk berhasil dihapus");
                    }else{
                        System.out.println("Produk tidak ditemukan");
                    }
                }
            }else if(menu == 5){
                break;
            }else{
                System.out.println("Invalid Menu!");
            }
        }
    }
}
