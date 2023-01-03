package com.bit.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-25 16:07
 */

public class Demo {
    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
           stmt = conn.createStatement();
           String sql = "select *from t_user";
          rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id=rs.getString(1);
                String name=rs.getString(2);
                System.out.println(id+","+name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
