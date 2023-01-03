package com.bit.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcInsert {

    public static void main(String[] args) throws SQLException {

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/javamysql?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");


        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号: ");
        int num = scanner.nextInt();
        System.out.println("请输入姓名: ");
        String name = scanner.next();
        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, num);
        statement.setString(2, name);
        System.out.println(statement);
        int n = statement.executeUpdate();
        System.out.println("n = " + n);
        statement.close();
        connection.close();
    }
}
