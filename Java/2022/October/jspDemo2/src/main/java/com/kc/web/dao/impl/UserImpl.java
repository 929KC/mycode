package com.kc.web.dao.impl;

import com.kc.web.dao.UserMapper;
import com.kc.web.utils.DBUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * @author 929KC
 * @date 2022/11/10 11:26
 * @description:
 */
public class UserImpl implements UserMapper {
    @Override
    @SneakyThrows
    public void addUser(String username, String password,String email, String gender,String educationBackground) {
        String sql = "insert  into user(username,password,email,gender,educationBackground) values(?,?,?,?,?)";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        statement.setString(3,email);
        statement.setString(4,gender);
        statement.setString(5,educationBackground);
        int  result = statement.executeUpdate();
        if (result>0) {
            System.out.println("插入成功");
        }
        statement.close();
        connection.close();
    }

}
