package tubespbo;

public class Users extends Akun {
    public Users(String username, String password) {
        super(username, password);
    }

    @Override
    void login() {
        System.out.println("User " + getUsername() + " logged in.");
    }

    @Override
    void logout() {
        System.out.println("User " + getUsername() + " logged out.");
    }

    // Menampilkan profil pengguna
    public void tampilkanProfil() {
        System.out.println("Profil Pengguna:");
        System.out.println("Username: " + getUsername());
    }
}

