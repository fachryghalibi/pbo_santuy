/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class BookingJadwal {
    private String tanggalBooking;
    private String waktuBooking;
    // atribut lain sesuai kebutuhan

    public BookingJadwal(String tanggalBooking, String waktuBooking) {
        this.tanggalBooking = tanggalBooking;
        this.waktuBooking = waktuBooking;
    }

    // Getter dan setter untuk tanggalBooking
    public String getTanggalBooking() {
        return tanggalBooking;
    }

    public void setTanggalBooking(String tanggalBooking) {
        this.tanggalBooking = tanggalBooking;
    }

    // Getter dan setter untuk waktuBooking
    public String getWaktuBooking() {
        return waktuBooking;
    }

    public void setWaktuBooking(String waktuBooking) {
        this.waktuBooking = waktuBooking;
    }
}


