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
public class loginSession {
    private static int id_user;
    private static String username;
    private static String password;
    private static String nama;
    private static String no_hp;

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        loginSession.id_user = id_user;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        loginSession.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        loginSession.password = password;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        loginSession.nama = nama;
    }

    public static String getNo_hp() {
        return no_hp;
    }

    public static void setNo_hp(String no_hp) {
        loginSession.no_hp = no_hp;
    }
    
    
    
    public static void clearSession(){
        id_user = 0;
        username = null;
        password = null;
        nama = null;
        username = null;
    }
}
