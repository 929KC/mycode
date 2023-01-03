package com.kc.web.utils;

import com.kc.web.model.BeanClass;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jsp";
    private static String user = "root";
    private static String password = "2222";
    static {
        //注册驱动
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {

        Connection conn1 = null;
        conn1 = DriverManager.getConnection(url, user, password);
        return conn1;
    }

    public static int inserInto(String sql, BeanClass xx){
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn= getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,xx.getCno());
            ps.setString(2,xx.getCname());
            ps.setString(3,xx.getTname());
            ps.setString(4,xx.getMajor());
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return count;
    }
    //关闭连接
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if ((ps!=null)){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
