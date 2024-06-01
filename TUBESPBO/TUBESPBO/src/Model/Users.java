package Model;

public class Users extends Akun {
    private String username;
    private String password;
    private String nama;
    private String no_hp;
    private String role;

    public Users(String username, String password, String nama, String no_hp, String role) {
        super(username, password, nama, no_hp, role);
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_hp = no_hp;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

