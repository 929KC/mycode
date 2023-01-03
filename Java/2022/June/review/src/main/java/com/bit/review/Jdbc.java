package com.bit.review;

import java.sql.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-21 15:59
 */

public class Jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        Statement  stmt=null;
        ResultSet rs=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&useUnicode=true&characterEncoding=UTF-8","root","123456");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql="delete from books where bookID=1";
            int i = stmt.executeUpdate(sql);
            System.out.println(i==1?"删除成成功":"删除失败");

//             rs = stmt.executeQuery(sql);

//            //5.处理查询结果集
//            while (rs.next()) {
//            String bookID=rs.getString(1);
//            String bookName=rs.getString(2);
//            String bookCount=rs.getString(3);
//            String detail=rs.getString(4);
//            System.out.println(bookID+","+bookName+","+bookCount+","+detail+"!");
//            }
            //6.释放资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt != null){
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
}
