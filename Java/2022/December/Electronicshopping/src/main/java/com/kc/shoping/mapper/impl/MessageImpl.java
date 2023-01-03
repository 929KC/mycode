package com.kc.shoping.mapper.impl;

import com.kc.shoping.mapper.MessageMapper;
import com.kc.shoping.model.Message;
import com.kc.shoping.utils.DBUtil;
import com.kc.shoping.vo.MessageVo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 8:26
 * @description:
 */
public class MessageImpl implements MessageMapper {
    @Override
    public List<Message> queryUserMessage() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Message> list = null;
        try {
            String sql = "select t_user.name,t_message.id,userId,title,content,time from t_message , t_user where t_user.id = t_message.userId;";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Message message = new Message(rs.getInt("id"), rs.getInt("userId"), rs.getString("name"), rs.getString("title"), rs.getString("content"), rs.getString("time"));
                list.add(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;
    }

    @Override
    public MessageVo queryMessageVo(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        MessageVo message = null;
        try {
            String sql = "select title,content,time from t_message  where id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                message = new MessageVo(rs.getString("title"), rs.getString("content"), rs.getString("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return message;
    }

    @Override
    public int deleteMessage(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i= 0;
        try {
            String sql = "delete from  t_message where id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            i = statement.executeUpdate();
            if (i>0) {
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
     return i;
    }
}
