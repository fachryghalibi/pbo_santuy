package Controller;

import Helper.db_connection;
import Model.login;
import View.Beranda;
import View.HalamanBerandaUser;
import View.Login;
import View.menuAdmin;
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
        String userSQL = "SELECT * FROM akun WHERE username = ? AND password = ?";
        String adminSQL = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection con = db_connection.getConnection();
             PreparedStatement userStmt = con.prepareStatement(userSQL);
             PreparedStatement adminStmt = con.prepareStatement(adminSQL)) {

            // Check user table
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            try (ResultSet userRs = userStmt.executeQuery()) {
                if (userRs.next()) {
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
                    menuAdmin newMenuAdmin = new menuAdmin();
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
