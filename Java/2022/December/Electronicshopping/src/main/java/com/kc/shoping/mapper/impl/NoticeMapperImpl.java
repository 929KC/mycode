package com.kc.shoping.mapper.impl;

import com.kc.shoping.mapper.NoticeMapper;
import com.kc.shoping.model.Message;
import com.kc.shoping.model.Notice;
import com.kc.shoping.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 16:02
 * @description:
 */
public class NoticeMapperImpl implements NoticeMapper {
    @Override
    public List<Notice> queryNotice() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Notice> list = null;
        try {
            String sql = "select * from t_notice";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Notice notice = new Notice(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("time"));
                list.add(notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;

    }

    @Override
    public void deleteNotice(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i= 0;
        try {
            String sql = "delete from  t_notice where id = ?";
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
    }

    @Override
    public void addNotice(String title, String content) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i= 0;
        try {
            String sql = "insert into t_notice(title,content) values(?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, content);
            i = statement.executeUpdate();
            if (i>0) {
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
    }
}
