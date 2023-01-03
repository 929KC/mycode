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
 * @date 2022/11/24 12:55
 * @description:
 */
public class StudnetImpl implements StudentMapper {
    @Override
    public List<Student> query() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList();
        try {
            connection = DBUtil.getConnection();
            String sql = "select *from student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String gender = resultSet.getString("gender");
                String username = resultSet.getString("username");
                String card = resultSet.getString("card");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setId(id);
                student.setGender(gender);
                student.setUsername(username);
                student.setCard(card);
                student.setPhone(phone);
                student.setAddress(address);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            DBUtil.close(connection,statement,resultSet);
        }
        return list;
    }
}
