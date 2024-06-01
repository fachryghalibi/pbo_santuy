package tubespbo;

public class Admin extends Akun {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    void login() {
        System.out.println("Admin " + getUsername() + " logged in.");
    }

    @Override
    void logout() {
        System.out.println("Admin " + getUsername() + " logged out.");
    }
}
