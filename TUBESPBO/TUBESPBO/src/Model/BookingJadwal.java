/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class BookingJadwal {
    private int id_booking;
    private int id_user;
    private String namaPasien;
    private String tanggalBooking;
    private String waktuBooking;
    private String namaDokter;
    private String status;

    public BookingJadwal(int id_booking, int id_user, String namaPasien, String tanggalBooking, String waktuBooking, String namaDokter, String status) {
        this.id_booking = id_booking;
        this.id_user = id_user;
        this.namaPasien = namaPasien;
        this.tanggalBooking = tanggalBooking;
        this.waktuBooking = waktuBooking;
        this.namaDokter = namaDokter;
        this.status = status;
    }
    

    public int getId_booking() {
        return id_booking;
    }

    public void setId_booking(int id_booking) {
        this.id_booking = id_booking;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getTanggalBooking() {
        return tanggalBooking;
    }

    public void setTanggalBooking(String tanggalBooking) {
        this.tanggalBooking = tanggalBooking;
    }

    public String getWaktuBooking() {
        return waktuBooking;
    }

    public void setWaktuBooking(String waktuBooking) {
        this.waktuBooking = waktuBooking;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    


    

    
}


