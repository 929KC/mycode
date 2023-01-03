package com.bit.ajax;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-25 15:25
 */

public class DBUtils {
    //文件资源绑定器
    private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    //根据配置文件key获取value
    private  static final String driver=bundle.getString("driver");
    private static final  String url=bundle.getString("url");
    private static final String user=bundle.getString("user");
    private static final String passWord=bundle.getString("password");

    static{
        //注册驱动(注册驱动只需要注册一次)
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return conn连接对象
     */
    public static Connection getConnection() throws SQLException {
        //获取连接
        Connection conn = DriverManager.getConnection(url,user,passWord);
        return conn;
    }

    /**
     *
     * @param conn 连接对象
     * @param ps 数据库连接对象
     * @param rs 结果集对象
     */
    public static  void close(Connection conn,PreparedStatement ps, ResultSet rs)  {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
