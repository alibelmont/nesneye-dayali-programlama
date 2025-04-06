import java.util.Scanner;

public class Sinema {
    static final int max_film = 10;
    static final int max_musteri = 20;

    static String[] filmadlari = new String[max_film];
    static int[] filmsureleri = new int[max_film];
    static String[] filmturleri = new String[max_film];
    static int filmsayisi = 0;

    static String[] musteriadlari = new String[max_musteri];
    static String[] musterimailleri = new String[max_musteri];
    static int musterisayisi = 0;

    static int[][] biletkayitlari = new int[max_musteri][max_film]; // 1 varsa bilet alınmış

    static Scanner giris = new Scanner(System.in);

    public static void main(String[] args) {
        int secim;

        do {
            System.out.println("\n--- Sinema Sistemi ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Musteri Ekle");
            System.out.println("3. Bilet Satın Al");
            System.out.println("4. Filmleri Goster");
            System.out.println("5. Musterileri Goster");
            System.out.println("6. Biletleri Goster");
            System.out.println("0. Cikis");
            System.out.print("Secim: ");
            secim = giris.nextInt();
            giris.nextLine(); // boş satırı temizle

            if (secim == 1) filmEkle();
            else if (secim == 2) musteriEkle();
            else if (secim == 3) biletAl();
            else if (secim == 4) filmleriGoster();
            else if (secim == 5) musterileriGoster();
            else if (secim == 6) biletleriGoster();
            else if (secim != 0) System.out.println("Gecersiz secim");
        } while (secim != 0);
    }

    static void filmEkle() {
        if (filmsayisi >= max_film) {
            System.out.println("Daha fazla film ekleyemezsin");
            return;
        }

        System.out.print("Film Adı: ");
        filmadlari[filmsayisi] = giris.nextLine();

        System.out.print("Film Suresi (dk): ");
        filmsureleri[filmsayisi] = giris.nextInt();
        giris.nextLine();

        System.out.print("Film Turu: ");
        filmturleri[filmsayisi] = giris.nextLine();

        filmsayisi++;
        System.out.println("Film eklendi");
    }

    static void musteriEkle() {
        if (musterisayisi >= max_musteri) {
            System.out.println("Daha fazla musteri ekleyemezsin");
            return;
        }

        System.out.print("Musteri Adı: ");
        musteriadlari[musterisayisi] = giris.nextLine();

        System.out.print("Musteri mail adresi: ");
        musterimailleri[musterisayisi] = giris.nextLine();

        musterisayisi++;
        System.out.println("Musteri eklendi");
    }

    static void biletAl() {
        System.out.println("Musteri No (0-" + (musterisayisi - 1) + "): ");
        int musteriNo = giris.nextInt();

        System.out.println("Film No (0-" + (filmsayisi - 1) + "): ");
        int filmNo = giris.nextInt();

        if (musteriNo >= 0 && musteriNo < musterisayisi && filmNo >= 0 && filmNo < filmsayisi) {
            biletkayitlari[musteriNo][filmNo] = 1;
            System.out.println("Bilet alındı");
        } else {
            System.out.println("Gecersiz");
        }
    }

    static void filmleriGoster() {
        System.out.println("\n-- Filmler --");
        for (int i = 0; i < filmsayisi; i++) {
            System.out.println(i + ": " + filmadlari[i] + " - " + filmsureleri[i] + " dk - " + filmturleri[i]);
        }
    }

    static void musterileriGoster() {
        System.out.println("\n-- Musteriler --");
        for (int i = 0; i < musterisayisi; i++) {
            System.out.println(i + ": " + musteriadlari[i] + " - " + musterimailleri[i]);
        }
    }

    static void biletleriGoster() {
        System.out.println("\n-- Biletler --");
        for (int i = 0; i < musterisayisi; i++) {
            System.out.print(musteriadlari[i] + ": ");
            for (int j = 0; j < filmsayisi; j++) {
                if (biletkayitlari[i][j] == 1) {
                    System.out.print(filmadlari[j] + " | ");
                }
            }
            System.out.println();
        }
    }
}
