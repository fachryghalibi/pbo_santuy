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
public abstract class Akun {
    private String username;
    private String password;
    private String nama;
    private String no_hp;


    public Akun(String username, String password, String nama, String no_hp) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_hp() {
        return no_hp;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    
    


}
