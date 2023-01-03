package com.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class BookDemo {
    public static void main(String[] args) throws SQLException {
      //  insert();
    // select();
       //update();
        delete();
    }

    private static void delete() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = " delete tmp from borrow_info as tmp,(select max(id) as max_id from borrow_info) as borrow where borrow.max_id = tmp.id;";
        PreparedStatement statement = connection.prepareStatement(sql);
        int i = statement.executeUpdate();
        System.out.println(i);
        System.out.println(statement);
        DBUtils.close(connection,statement);
    }

    private static void update() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "update  book set price = ?  where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("请输入price:");
        double price = sc.nextDouble();
        System.out.println("请输入书名:");
        String name = sc.next();
        statement.setDouble(1, price);
        statement.setString(2,name);
        int i = statement.executeUpdate();
        System.out.println(statement);
        DBUtils.close(connection,statement);
    }

    public static  void  insert() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "insert into borrow_info(id,book_id,student_id,start_time,end_time)  values(?,?,?,?,?) ";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("请输入id:");
        int id = sc.nextInt();
        System.out.println("请输入book_id:");
        int book_id = sc.nextInt();
        System.out.println("请输入student_id:");
        int student_id = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入start_time:");
        String start_time = sc.nextLine();
        System.out.println("请书输入end_time:");
        String end_time = sc.nextLine();
        statement.setInt(1,id);
        statement.setInt(2,book_id);
        statement.setInt(3,student_id);
        statement.setString(4,start_time);
        statement.setString(5,end_time);
        int i = statement.executeUpdate();
        System.out.println(i);
        System.out.println(statement);
        DBUtils.close(connection,statement);
    }

    public  static  void select() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Scanner sc = new Scanner(System.in);
        String sql = "select    borrow_info.id,book_id,student_id,start_time,end_time,book.name,book.author from borrow_info join book on  borrow_info.book_id = book.id join category on category_id = category.id where category.id = 3";
        PreparedStatement statement = connection.prepareStatement(sql);
//        System.out.println("请输入category.id:");
//       int category_id = sc.nextInt();
//        statement.setInt(1,category_id);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int borrow_info_id = resultSet.getInt("id");
            int book_id = resultSet.getInt("book_id");
            int student_id = resultSet.getInt("student_id");
            String start_time = resultSet.getString("start_time");
            String end_time = resultSet.getString("end_time");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            System.out.println(borrow_info_id+" "+book_id + " " + student_id + " " + start_time+" "+end_time+" " +name+" "+author);
        }
       DBUtils.close(connection,statement,resultSet);
    }
}
