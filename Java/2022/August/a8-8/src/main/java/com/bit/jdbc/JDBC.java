package com.bit.jdbc;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    public static void test() throws SQLException {
        // 1. 创建数据库源，连接 Connection
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");
        Connection connection=dataSource.getConnection();

        // 2. 构造一个 SQL 语句，为要进行的操作做准备
        String sql="";
        PreparedStatement statement=connection.prepareStatement(sql);

        // 3. 执行 SQL，并处理结果集
        int ret=statement.executeUpdate();

        // 4. 执行完成，释放资源
        statement.close();
        connection.close();
    }

}
