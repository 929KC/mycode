package com.bit.review;

import java.sql.*;
import java.util.ResourceBundle;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-21 15:55
 */

public class Utils {
    public static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static final String url = bundle.getString("url");
    private static final String username = bundle.getString("username");
    private static final String password = bundle.getString("password");
    private  static final String driver=bundle.getString("driver");

   static{
       try {
           Class.forName(driver);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
   }

   public static Connection getConnection() throws SQLException {
   Connection con = DriverManager.getConnection(url, username, password);
        return con;
   }
   public static void close(Connection conn, Statement stmt, ResultSet rs) {
    if(rs!=null){
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    if(stmt!=null){
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    if(conn != null){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
   }
}
