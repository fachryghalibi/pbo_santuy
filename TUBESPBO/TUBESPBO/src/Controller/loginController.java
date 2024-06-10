/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Helper.PasswordUtils;
import Helper.db_connection;
import Model.login;
import Model.loginSession;
import View.HalamanBerandaUser;
import View.Login;
import View.MenuAdmin;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */

public class loginController implements login {
    private Login asLogin;

    public loginController(Login asLogin) {
        this.asLogin = asLogin;
    }

    public void login(String username, String password) {
        String userSQL = "SELECT * FROM users WHERE username = ?";
        String adminSQL = "SELECT * FROM admin WHERE username = ?";

        try (Connection con = db_connection.getConnection();
             PreparedStatement userStmt = con.prepareStatement(userSQL);
             PreparedStatement adminStmt = con.prepareStatement(adminSQL)) {

            userStmt.setString(1, username);
            try (ResultSet userRs = userStmt.executeQuery()) {
                if (userRs.next()) {
                    String storedPassword = userRs.getString("password");
                    byte[] salt = userRs.getBytes("salt");
                    String hashedPassword = PasswordUtils.hashPassword(password, salt);

                    if (storedPassword.equals(hashedPassword)) {
                        int id_user = userRs.getInt("id_akun");
                        String Username = userRs.getString("username");
                        String Nama = userRs.getString("nama");
                        String No_hp = userRs.getString("no_hp");

                        loginSession.setId_user(id_user);
                        loginSession.setNama(Nama);
                        loginSession.setNo_hp(No_hp);
                        loginSession.setPassword(password);
                        loginSession.setUsername(Username);

                        HalamanBerandaUser newBeranda = new HalamanBerandaUser();
                        newBeranda.setVisible(true);
                        this.asLogin.dispose();
                        return;
                    }
                }
            }

            adminStmt.setString(1, username);
            try (ResultSet adminRs = adminStmt.executeQuery()) {
                if (adminRs.next()) {
                    int id_user = adminRs.getInt("id_user");
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
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);
        }
        
        
    }
}
