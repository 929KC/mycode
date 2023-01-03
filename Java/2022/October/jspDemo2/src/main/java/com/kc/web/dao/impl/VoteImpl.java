package com.kc.web.dao.impl;

import com.kc.web.dao.VoteMapper;
import com.kc.web.model.Vote;
import com.kc.web.utils.DBUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class VoteImpl implements VoteMapper {
    @SneakyThrows
    @Override
    public int getNumb(String countries) {
        String sql = "select numb from vote where content = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,countries);
        ResultSet resultSet = statement.executeQuery();
        int numb = 0;
        while (resultSet.next()) {
           numb = resultSet.getInt("numb");
        }
        return numb;
    }
    @SneakyThrows
    @Override
    public void updateNumb(String countries,int numb) {
        String sql = "update vote set numb = ? where content = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,numb);
        statement.setString(2,countries);
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
    @SneakyThrows
    @Override
    public List<Vote> getVotes() {
        List<Vote> list = new ArrayList<>();
        String sql = "select id,content,numb from vote ";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String content = result.getString("content");
            int numb = result.getInt("numb");
            Vote vote = new Vote();
            vote.setId(id);
            vote.setContent(content);
            vote.setNumb(numb);
            list.add(vote);
        }
        DBUtil.close(connection,statement,result);
        return  list;
    }
    @SneakyThrows
    @Override
    public int getSumNumb() {
        String sql = "select sum(numb) as sumnumb from vote";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        int sumnumb = 0;
        while (result.next()) {
            sumnumb = result.getInt("sumnumb");
        }
        return sumnumb;
    }

}
