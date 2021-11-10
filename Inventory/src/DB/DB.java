/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gihan_chaturanga
 */
public class DB {
    private static Connection connection;
    
    private static void init() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "gihan98@");
    }
    
    public static void iud(String sql) throws Exception{
        if (connection == null) {
            init();
        }
        connection.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet search(String sql) throws Exception{
        if (connection == null) {
            init();
        }
        return connection.createStatement().executeQuery(sql);
    }
    
    public static Connection getNewConnection() throws Exception{
        if (connection == null) {
            init();
        }
        return connection;
    }
    
    public static PreparedStatement getnewPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        if (connection == null) {
            init();
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }
}
