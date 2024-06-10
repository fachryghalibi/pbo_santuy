/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.PasswordUtils;
import Helper.db_connection;
import java.security.NoSuchAlgorithmException;
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
    public boolean registerAkun(String username, String password, String nama, String no_hp, String role) {
        String sql = "INSERT INTO users (username, password, salt, nama, no_hp, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = db_connection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            byte[] salt = PasswordUtils.getSalt();
            String hashedPassword = PasswordUtils.hashPassword(password, salt);
            
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setBytes(3, salt);
            pstmt.setString(4, nama);
            pstmt.setString(5, no_hp);
            pstmt.setString(6, role);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException | NoSuchAlgorithmException e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);        
        }
        return false;
    }
    
    public boolean updateAkun(String username, String password, String nama, String no_hp, String role) {
        String sql = "UPDATE users SET password = ?, nama = ?, no_hp = ?, role = ? WHERE username = ?";
        try (Connection con = db_connection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
             
            byte[] salt = PasswordUtils.getSalt();
            String hashedPassword = PasswordUtils.hashPassword(password, salt);
            
            pstmt.setString(1, hashedPassword);
            pstmt.setString(2, nama);
            pstmt.setString(3, no_hp);
            pstmt.setString(4, role);
            pstmt.setString(5, username);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException | NoSuchAlgorithmException e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error updating data", e);
        }
        return false;
    }
}
