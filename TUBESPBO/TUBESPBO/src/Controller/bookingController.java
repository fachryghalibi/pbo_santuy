/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.db_connection;
import Model.BookingJadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class bookingController {
    public boolean bookingJadwal(int id_akun,String namaPasien, String tanggalBooking, String waktuBooking, String namaDokter, String status){
    String sql = "INSERT INTO bookingjadwal (id_user, namaPasien, tanggalBooking, waktuBooking, namaDokter, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)    ){
            pstmt.setInt(1, id_akun);
            pstmt.setString(2, namaPasien);
            pstmt.setString(3, tanggalBooking);
            pstmt.setString(4, waktuBooking);
            pstmt.setString(5, namaDokter);
            pstmt.setString(6, status);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
        Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);        
        } return false;
    }
    
    public List<BookingJadwal>getAllBookingJadwal(){
        List<BookingJadwal> dataBooking = new ArrayList<>();
        String sql = "SELECT * FROM bookingjadwal";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)    ){
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    
                    int id_booking = rs.getInt("id_booking");
                    int id_user = rs.getInt("id_user");
                    String namaPasien = rs.getString("namaPasien");
                    String waktuBooking = rs.getString("waktuBooking");
                    String tanggalBooking = rs.getString("tanggalBooking");
                    String namaDokter = rs.getString("namaDokter");
                    String status = rs.getString("status");
                    
                    BookingJadwal bj = new BookingJadwal(id_booking, id_user, namaPasien, tanggalBooking, waktuBooking, namaDokter, status);
                    dataBooking.add(bj);              
                }
            }
        } catch (Exception e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);
        }
        return dataBooking;
    }
    
    public List<BookingJadwal>getAllBookingJadwalbyIDUser(int id_User, String Status){
        List<BookingJadwal> dataBooking = new ArrayList<>();
        String sql = "SELECT * FROM bookingjadwal where id_user = ? and status = ?";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)    ){
            pstmt.setInt(1, id_User);
            pstmt.setString(2, Status);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    
                    int id_booking = rs.getInt("id_booking");
                    int id_user = rs.getInt("id_user");
                    String namaPasien = rs.getString("namaPasien");
                    String waktuBooking = rs.getString("waktuBooking");
                    String tanggalBooking = rs.getString("tanggalBooking");
                    String namaDokter = rs.getString("namaDokter");
                    String status = rs.getString("status");
                    
                    BookingJadwal bj = new BookingJadwal(id_booking, id_user, namaPasien, tanggalBooking, waktuBooking, namaDokter, status);
                    dataBooking.add(bj);              
                }
            }
        } catch (Exception e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);
        }
        return dataBooking;
    } 
    
    public List<BookingJadwal>getAllBookingJadwalbyIDUser(int id_User){
        List<BookingJadwal> dataBooking = new ArrayList<>();
        String sql = "SELECT * FROM bookingjadwal where id_user = ?";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)    ){
            pstmt.setInt(1, id_User);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    
                    int id_booking = rs.getInt("id_booking");
                    int id_user = rs.getInt("id_user");
                    String namaPasien = rs.getString("namaPasien");
                    String waktuBooking = rs.getString("waktuBooking");
                    String tanggalBooking = rs.getString("tanggalBooking");
                    String namaDokter = rs.getString("namaDokter");
                    String status = rs.getString("status");
                    
                    BookingJadwal bj = new BookingJadwal(id_booking, id_user, namaPasien, tanggalBooking, waktuBooking, namaDokter, status);
                    dataBooking.add(bj);              
                }
            }
        } catch (Exception e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);
        }
        return dataBooking;
    } 
    
    public boolean ubahStatus(int Id_Booking, String status){
        String sql = "UPDATE bookingjadwal set status = ? where id_booking = ?";
        try (Connection con = db_connection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, status);
            pstmt.setInt(2, Id_Booking);
            
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            Logger.getLogger(akunController.class.getName()).log(Level.SEVERE, "Error inserting data", e);
            return false;
        }
        
    }
}
