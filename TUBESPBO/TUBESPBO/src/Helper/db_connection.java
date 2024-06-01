/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author FACHRUDDIN GHALIBI
 */
public class db_connection {
    private static Connection con;
    public static Connection getConnection() throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/db_tubespbo";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new Driver());
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
