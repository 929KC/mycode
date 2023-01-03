package com.kc.blog.dao.impl;

import com.kc.blog.dao.UserMapper;
import com.kc.blog.model.User;
import com.kc.blog.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 929KC
 * @date 2022/11/30 14:37
 * @description:
 */
public class UserImpl implements UserMapper {
    @Override
    public User getUserByName(String userName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "select *from user where username=?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "select *from user where userId=?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return null;
    }

    @Override
    public void insetUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into user(username, password) values(?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
