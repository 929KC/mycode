package com.kc.jsp.dao.impl;

import com.kc.jsp.dao.StudentMapper;
import com.kc.jsp.model.Student;
import com.kc.jsp.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/11/28 7:39
 * @description:
 */
public class StudentImpl implements StudentMapper {

    @Override
    public List<Student> queryAll() {
        List<Student> list = new ArrayList<>();
        Student stu = null;
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stu = new Student(rs.getInt("id"), rs.getString("gender"),
                        rs.getString("username"), rs.getString("card"), rs.getString("phone"),
                        rs.getString("address"));
                list.add(stu);
            }
            DBUtil.close(conn, ps, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Student student) {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "insert into student(id,gender,username,card,phone,address) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getGender());
            ps.setString(3, student.getUsername());
            ps.setString(4, student.getCard());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getAddress());
            ps.executeUpdate();
            DBUtil.close(conn, ps, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
