import java.util.ArrayList;
import java.util.Scanner;

public class Gemini {
    public static void main(String[] args) {
        ArrayList<Kendaraan> listKendaraan = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int menu = 0;

        while (menu != 6) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Kendaraan Baru");
            System.out.println("2. Lihat / Cari Kendaraan");
            System.out.println("3. Ubah Tarif Sewa");
            System.out.println("4. Hapus Kendaraan");
            System.out.println("5. Transaksi Sewa Kendaraan");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            try {
                menu = input.nextInt();
                input.nextLine(); // Flushing buffer
            } catch (Exception e) {
                input.nextLine(); // Handling jika input bukan angka
                menu = 0;
            }

            if (menu == 1) {
                System.out.println("\n--- Tambah Kendaraan Baru ---");
                System.out.println("Pilih Jenis Kendaraan:");
                System.out.println("1. Mobil");
                System.out.println("2. Motor");
                System.out.print("Pilih (1/2): ");
                int pilihan = input.nextInt();
                input.nextLine(); // Flushing buffer

                if (pilihan == 1 || pilihan == 2) {
                    System.out.print("Input Plat Nomor Kendaraan: ");
                    String plat = input.nextLine();

                    // Cek duplikasi plat nomor pada ArrayList
                    boolean isExist = false;
                    for (Kendaraan k : listKendaraan) {
                        if (k.getPlat().equalsIgnoreCase(plat)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        System.out.println("ERROR: Plat nomor '" + plat + "' sudah terdaftar dalam sistem!");
                    } else {
                        System.out.print("Masukkan Merk Kendaraan: ");
                        String merk = input.nextLine();
                        System.out.print("Masukkan Harga Sewa Dasar (/hari): ");
                        double harga = input.nextDouble();
                        input.nextLine(); // Flushing buffer

                        if (pilihan == 1) {
                            System.out.print("Apakah menggunakan sopir? (true/false): ");
                            boolean sopir = input.nextBoolean();
                            double sewaSopir = 0;
                            
                            if (sopir) {
                                System.out.print("Masukkan Biaya Sewa Sopir (/hari): ");
                                sewaSopir = input.nextDouble();
                            }
                            input.nextLine(); // Flushing buffer

                            listKendaraan.add(new Mobil(plat, merk, harga, sopir, sewaSopir));
                            System.out.println("SUCCESS: Mobil berhasil ditambahkan!");

                        } else if (pilihan == 2) {
                            System.out.print("Masukkan Jumlah Helm: ");
                            int helm = input.nextInt();
                            input.nextLine(); // Flushing buffer

                            listKendaraan.add(new Motor(plat, merk, harga, helm));
                            System.out.println("SUCCESS: Motor berhasil ditambahkan!");
                        }
                    }
                } else {
                    System.out.println("Pilihan jenis kendaraan tidak valid.");
                }

            } else if (menu == 2) { // READ
                if (listKendaraan.isEmpty()) {
                    System.out.println("Daftar kendaraan masih kosong.");
                } else {
                    System.out.println("\n--- Menu Lihat / Cari Kendaraan ---");
                    System.out.println("1. Lihat Semua Kendaraan");
                    System.out.println("2. Cari Kendaraan Berdasarkan Plat Nomor");
                    System.out.print("Pilih (1/2): ");
                    int subMenu = input.nextInt();
                    input.nextLine(); // Flushing buffer

                    if (subMenu == 1) {
                        System.out.println("\n=== DAFTAR SELURUH KENDARAAN ===");
                        for (int i = 0; i < listKendaraan.size(); i++) {
                            System.out.println("\n[Kendaraan Ke-" + (i + 1) + "]");
                            listKendaraan.get(i).displayInfo();
                        }
                    } else if (subMenu == 2) {
                        System.out.print("Masukkan Plat Nomor yang dicari: ");
                        String platCari = input.nextLine();

                        Kendaraan kendaraanDitemukan = null;
                        for (Kendaraan k : listKendaraan) {
                            if (k.getPlat().equalsIgnoreCase(platCari)) {
                                kendaraanDitemukan = k;
                                break;
                            }
                        }

                        if (kendaraanDitemukan != null) {
                            System.out.println("\n--- Detail Kendaraan Ditemukan ---");
                            kendaraanDitemukan.displayInfo();
                        } else {
                            System.out.println("Kendaraan dengan plat nomor '" + platCari + "' tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Pilihan sub-menu tidak valid.");
                    }
                }

            } else if (menu == 3) { // UPDATE
                if (listKendaraan.isEmpty()) {
                    System.out.println("Daftar kendaraan masih kosong.");
                } else {
                    System.out.println("\n--- Ubah Tarif Sewa Dasar ---");
                    System.out.print("Masukkan Plat Nomor kendaraan yang ingin diubah: ");
                    String platUbah = input.nextLine();

                    Kendaraan kendaraanUbah = null;
                    for (Kendaraan k : listKendaraan) {
                        if (k.getPlat().equalsIgnoreCase(platUbah)) {
                            kendaraanUbah = k;
                            break;
                        }
                    }

                    if (kendaraanUbah != null) {
                        System.out.println("Harga sewa dasar saat ini: Rp" + kendaraanUbah.getHarga());
                        System.out.print("Masukkan Harga Sewa Dasar Baru (/hari): ");
                        double hargaBaru = input.nextDouble();
                        input.nextLine(); // Flushing buffer

                        kendaraanUbah.setHarga(hargaBaru);
                        System.out.println("SUCCESS: Tarif sewa dasar berhasil diperbarui!");
                    } else {
                        System.out.println("Kendaraan dengan plat nomor '" + platUbah + "' tidak ditemukan.");
                    }
                }

            } else if (menu == 4) { // DELETE
                if (listKendaraan.isEmpty()) {
                    System.out.println("Daftar kendaraan masih kosong.");
                } else {
                    System.out.println("\n--- Hapus Kendaraan ---");
                    System.out.print("Masukkan Plat Nomor kendaraan yang ingin dihapus: ");
                    String platHapus = input.nextLine();

                    int indexHapus = -1;
                    for (int i = 0; i < listKendaraan.size(); i++) {
                        if (listKendaraan.get(i).getPlat().equalsIgnoreCase(platHapus)) {
                            indexHapus = i;
                            break;
                        }
                    }

                    if (indexHapus != -1) {
                        listKendaraan.remove(indexHapus);
                        System.out.println("SUCCESS: Kendaraan dengan plat nomor '" + platHapus + "' berhasil dihapus!");
                    } else {
                        System.out.println("Kendaraan dengan plat nomor '" + platHapus + "' tidak ditemukan.");
                    }
                }

            } else if (menu == 5) { // TRANSAKSI SEWA
                if (listKendaraan.isEmpty()) {
                    System.out.println("Daftar kendaraan masih kosong.");
                } else {
                    System.out.println("\n--- Transaksi Sewa Kendaraan ---");
                    System.out.print("Masukkan Plat Nomor kendaraan yang akan disewa: ");
                    String platSewa = input.nextLine();

                    Kendaraan kendaraanSewa = null;
                    for (Kendaraan k : listKendaraan) {
                        if (k.getPlat().equalsIgnoreCase(platSewa)) {
                            kendaraanSewa = k;
                            break;
                        }
                    }

                    if (kendaraanSewa != null) {
                        System.out.print("Masukkan Durasi Sewa (jumlah hari): ");
                        int durasiHari = input.nextInt();
                        input.nextLine(); // Flushing buffer

                        if (durasiHari > 0) {
                            double totalBiaya = kendaraanSewa.hitungBiaya(durasiHari);

                            System.out.println("\n=== RINGKASAN TRANSAKSI SEWA ===");
                            System.out.println("Plat Nomor  : " + kendaraanSewa.getPlat());
                            System.out.println("Merk        : " + kendaraanSewa.getMerk());
                            System.out.println("Durasi Sewa : " + durasiHari + " hari");
                            System.out.println("Total Biaya : Rp" + totalBiaya);

                            String catatanSewa = "Sewa " + durasiHari + " hari - Total: Rp" + totalBiaya;
                            kendaraanSewa.tambahRiwayat(catatanSewa);

                            System.out.println("SUCCESS: Transaksi berhasil dicatat ke riwayat!");
                        } else {
                            System.out.println("Durasi sewa harus lebih dari 0 hari.");
                        }
                    } else {
                        System.out.println("Kendaraan dengan plat nomor '" + platSewa + "' tidak ditemukan.");
                    }
                }

            } else if (menu == 6) {
                System.out.println("Terima kasih telah menggunakan aplikasi ini!");
            } else {
                System.out.println("Invalid menu!");
            }
        }

        input.close();
    }
}