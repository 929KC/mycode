package com.bit.review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-21 18:47
 */

public class UserUtils {
    public static void main(String[] args) {
        Connection  conn = null;;
        Statement stmt = null;
        ResultSet rs = null;
        try {
           conn = Utils.getConnection();
           stmt = conn.createStatement();
           //String sql="select *from books";
           // String sql="insert into books (bookID,bookName,bookCounts,detail) values(1,'java',90,'从入门到入土'),(4,'javaScript',100,'从入门到成神')";
            String sql="update books set bookID=1,bookName='MySql',bookCounts=90,detail='删库' where bookID=5;";
            int i = stmt.executeUpdate(sql);
            System.out.println(i==1?"添加成功":"添加失败");
          // rs= stmt.executeQuery(sql);
//           while (rs.next()) {
//               String bookID = rs.getString(1);
//               String bookName = rs.getString(2);
//               String bookCounts = rs.getString(3);
//               String detail=rs.getString(4);
//               System.out.println(bookID+","+bookName+","+bookCounts+","+detail);
//           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Utils.close(conn,stmt,rs);
    }
}
