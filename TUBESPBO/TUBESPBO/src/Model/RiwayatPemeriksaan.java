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
import java.util.ArrayList;

public class RiwayatPemeriksaan {
    private ArrayList<String> pemeriksaanList;

    public RiwayatPemeriksaan() {
        this.pemeriksaanList = new ArrayList<>();
    }

    public void tambahPemeriksaan(String pemeriksaan) {
        pemeriksaanList.add(pemeriksaan);
        System.out.println("Pemeriksaan baru berhasil ditambahkan: " + pemeriksaan);
    }

    public void tampilkanRiwayatPemeriksaan() {
        if (pemeriksaanList.isEmpty()) {
            System.out.println("Riwayat pemeriksaan masih kosong.");
        } else {
            System.out.println("Riwayat Pemeriksaan:");
            for (int i = 0; i < pemeriksaanList.size(); i++) {
                System.out.println((i + 1) + ". " + pemeriksaanList.get(i));
            }
        }
    }
}

