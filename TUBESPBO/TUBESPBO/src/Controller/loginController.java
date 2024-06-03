package Controller;

import Helper.db_connection;
import Model.login;
import Model.loginSession;
import View.HalamanBerandaUser;
import View.Login;
import View.MenuAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class loginController implements login {
    private Login asLogin;

    public loginController(Login asLogin) {
        this.asLogin = asLogin;
    }

    public void login(String username, String password) {
        String userSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
        String adminSQL = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection con = db_connection.getConnection();
             PreparedStatement userStmt = con.prepareStatement(userSQL);
             PreparedStatement adminStmt = con.prepareStatement(adminSQL)) {

            // Check user table
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            try (ResultSet userRs = userStmt.executeQuery()) {
                if (userRs.next()) {
                    int id_user = userRs.getInt("id_akun");
                    String Username = userRs.getString("username");
                    String Password = userRs.getString("password");
                    String Nama = userRs.getString("nama");
                    String No_hp = userRs.getString("no_hp");
                    
                    loginSession.setId_user(id_user);
                    loginSession.setNama(Nama);
                    loginSession.setNo_hp(No_hp);
                    loginSession.setPassword(Password);
                    loginSession.setUsername(Username);
                    
                    HalamanBerandaUser newBeranda = new HalamanBerandaUser();
                    newBeranda.setVisible(true);
                    this.asLogin.dispose();
                    return;
                }
            }

            // Check admin table
            adminStmt.setString(1, username);
            adminStmt.setString(2, password);
            try (ResultSet adminRs = adminStmt.executeQuery()) {
                if (adminRs.next()) {
                    int id_user = adminRs.getInt("id_akun");
                    String Username = adminRs.getString("username");
                    String Password = adminRs.getString("password");
                    String Nama = adminRs.getString("nama");
                    String No_hp = adminRs.getString("no_hp");
                    
                    loginSession.setId_user(id_user);
                    loginSession.setNama(Nama);
                    loginSession.setNo_hp(No_hp);
                    loginSession.setPassword(Password);
                    loginSession.setUsername(Username);
                    MenuAdmin newMenuAdmin = new MenuAdmin();
                    newMenuAdmin.setVisible(true);
                    this.asLogin.dispose();
                    return;
                    
                    
                    
                }
            }

            JOptionPane.showMessageDialog(null, "Harap Masukkan Username dan Password yang benar");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
        
        
    }
}

