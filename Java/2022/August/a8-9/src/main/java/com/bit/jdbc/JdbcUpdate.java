package com.bit.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUpdate {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("2222");
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/javamysql?characterEncoding=utf8&useSSL=false");
        Connection connection = dataSource.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "update student set name= ? where id = ?";
        System.out.println("请输入你的姓名:");
        String name = sc.next();
        System.out.println("请输入你的id:");
        int id = sc.nextInt();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2,id);
        int i = statement.executeUpdate();
        System.out.println(statement);
        System.out.println(i);
        statement.close();
        connection.close();
    }
}
