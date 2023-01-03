package com.kc.jsp;

import com.kc.model.domain.Student;
import com.kc.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    @Test
    public   void testDB() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "select id,name,gender,classname from student where classname= ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "21软件二班");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String gender = result.getString("gender");
            String classname1 = result.getString("classname");
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setGender(gender);
            student.setClassname(classname1);
            list.add(student);
        }
        DBUtil.close(connection,statement,result);
        System.out.println(list);
    }

    @Test
    public void test(){
        System.out.println("今天摸鱼");
    }
}
