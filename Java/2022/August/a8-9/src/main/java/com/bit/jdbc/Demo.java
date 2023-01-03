package com.bit.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws SQLException {
        //select();
        delete();
    }

    public static  void insert() throws SQLException {
        Connection connection = DBUtils.getConnection();
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
        DBUtils.close(connection,statement);
    }
    public static  void update() throws SQLException {
        Connection connection = DBUtils.getConnection();
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
        DBUtils.close(connection,statement);
    }

    public static  void select() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "select *from student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println("id"+id+","+"name"+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }


    public  static void  delete() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "delete from student where id = ?";
        System.out.println("请输入你的id:");
        int id = sc.nextInt();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        int i = statement.executeUpdate();
        System.out.println(statement);
        System.out.println(i);
        DBUtils.close(connection,statement);
    }


}
