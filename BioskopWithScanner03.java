/**
 * BioskopWithScanner03
 */
import java.util.Scanner;
 public class BioskopWithScanner03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] penonton = new String[4][2];
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih menu (1/2/3): ");
            int pilihanMenu = sc.nextInt();
            sc.nextLine();

            switch (pilihanMenu) {
                case 1:
                    System.out.print("Masukkan nama penonton: ");
                    String nama = sc.nextLine();
                    int baris, kolom;

                    while (true) {
                        System.out.print("Masukkan baris: ");
                        baris = sc.nextInt();
                        System.out.print("Masukkan kolom: ");
                        kolom = sc.nextInt();
                        sc.nextLine(); 

                        if (kursiTersedia(baris, kolom) && penonton[baris - 1][kolom - 1] == null) {
                            penonton[baris - 1][kolom - 1] = nama;
                            System.out.println("Data penonton berhasil disimpan.");
                            break;
                        } else {
                            System.out.println("Baris atau kolom tidak valid atau kursi sudah terisi. Harap coba lagi.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Daftar penonton:");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++) {
                            if (penonton[i][j] != null) {
                                System.out.printf("Baris %d, Kolom %d: %s\n", i + 1, j + 1, penonton[i][j]);
                            } else {
                                System.out.printf("Baris %d, Kolom %d: ***\n", i + 1, j + 1);
                            }
                        }
                    }
                    break;
                
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Menu tidak valid. Harap coba lagi.");
            }
        }
    }
    private static boolean kursiTersedia(int baris, int kolom) {
        return baris >= 1 && baris <= 4 && kolom >= 1 && kolom <= 2;
    } 
}