/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.db_connection;
import Model.login;
import View.Beranda;
import View.Login;
import View.menuAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class loginController implements login{
    private Login asLogin;
    public loginController(Login asLogin){
        this.asLogin = asLogin;
    }
    public void login(String username, String password){
        String SQL = "select * from akun where username = ? and password = ?";
        
        try (Connection con = db_connection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    String role = rs.getString("role");
                    if (role.equals("user")){
                        Beranda newBeranda = new Beranda();
                        newBeranda.setVisible(true);
                        this.asLogin.dispose();
                    }else if (role.equals("admin")){
                        menuAdmin newMenuAdmin = new menuAdmin();
                        newMenuAdmin.setVisible(true);
                        this.asLogin.dispose();
                    }else{
                      JOptionPane.showMessageDialog(null, "akun tidak terdaftar");  
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Harap Masukkan Username dan Password");
                }
            } 
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
