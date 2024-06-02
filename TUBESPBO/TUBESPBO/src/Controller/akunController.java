/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.db_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class akunController {
    public boolean registerAkun(String username, String password, String nama, String no_hp, String role){
    String sql = "INSERT INTO users (username, password, nama, no_hp, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)    ){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, nama);
            pstmt.setString(4, no_hp);
            pstmt.setString(5, role);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
        Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);        
        } return false;
    }
    
    
}

