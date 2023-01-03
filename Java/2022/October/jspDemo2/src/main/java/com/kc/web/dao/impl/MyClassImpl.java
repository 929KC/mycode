package com.kc.web.dao.impl;

import com.kc.web.dao.MyClassMapper;
import com.kc.web.model.MyClass;
import com.kc.web.utils.DBUtil;
import lombok.SneakyThrows;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyClassImpl implements MyClassMapper {
    @SneakyThrows
    @Override
    public void addMyClass(int id, String classname, String teacher, String professional) {
        String sql = "insert into myclass(id,classname,teacher,professional) value(?,?,?,?)";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,classname);
        statement.setString(3,teacher);
        statement.setString(4,professional);
        int i = statement.executeUpdate();
        if (i>0) {
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
       if(statement!=null) {
           statement.close();
       }
       if (connection!=null) {
           connection.close();
       }
    }

    @SneakyThrows
    @Override
    public List<MyClass> getMyClasses() {
        List<MyClass> list = new ArrayList<>();
        String sql = "select id,classname,teacher,professional from myclass ";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String classname = result.getString("classname");
            String teacher = result.getString("teacher");
            String professional = result.getString("professional");
            MyClass mc = new MyClass();
            mc.setId(id);
            mc.setClassname(classname);
            mc.setTeacher(teacher);
            mc.setProfessional(professional);
            list.add(mc);
        }
        DBUtil.close(connection,statement,result);
        return  list;
    }

    @SneakyThrows
    @Override
    public void deleteMyClasses(int id) {
        String sql = "delete from myclass where id = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        int i = statement.executeUpdate();
        if (i>0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        if(statement!=null) {
            statement.close();
        }
        if (connection!=null) {
            connection.close();
        }

    }

    @SneakyThrows
    @Override
    public void updateMyClasses(int id, String classname, String teacher, String professional) {
        String sql = "update myclass set classname = ?,teacher = ?,professional =  ? where id = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,classname);
        statement.setString(2,teacher);
        statement.setString(3,professional);
        statement.setInt(4,id);
        int i = statement.executeUpdate();
        if (i>0) {
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
        if(statement!=null) {
            statement.close();
        }
        if (connection!=null) {
            connection.close();
        }
    }
}
