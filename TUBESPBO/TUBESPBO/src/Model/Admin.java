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

public class Admin extends Akun {
    private String username;
    private String password;
    private String nama;
    private String no_hp;

    public Admin(String username, String password, String nama, String no_hp) {
        super(username, password, nama, no_hp);
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_hp = no_hp;

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getNo_hp() {
        return no_hp;
    }

    @Override
    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

}
