/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
import java.util.Scanner;

public class TUBESPBO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Aplikasi Telkom Medika ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login User");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan aplikasi Telkom Medika.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                    break;
            }
        }

        scanner.close();
    }

    public static void loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username admin:");
        String username = scanner.nextLine();
        System.out.println("Masukkan password admin:");
        String password = scanner.nextLine();
        Admin admin = new Admin(username, password);
        admin.login();
        // Lakukan operasi admin lainnya setelah login
        admin.logout();
        scanner.close();
    }

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username user:");
        String username = scanner.nextLine();
        System.out.println("Masukkan password user:");
        String password = scanner.nextLine();
        Users user = new Users(username, password);
        user.login();
        // Lakukan operasi user lainnya setelah login
        user.logout();
        scanner.close();
    }
}
