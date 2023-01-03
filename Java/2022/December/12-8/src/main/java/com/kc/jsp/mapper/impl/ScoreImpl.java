package com.kc.jsp.mapper.impl;

import com.kc.jsp.mapper.ScoreMapper;
import com.kc.jsp.model.AvgScore;
import com.kc.jsp.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 929KC
 * @date 2022/12/8 14:32
 * @description:
 */
public class ScoreImpl implements ScoreMapper {


    @Override
    public Map<String, Object> queryAvg() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Map<String,Object>  map = new HashMap<String,Object>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select courses.courseName,avg(scores.score) as avgscore from courses,scores where scores.courseId = courses.id GROUP BY courses.courseName";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
              list1.add(rs.getString("courseName"));
              list2.add(rs.getString("avgscore"));
              map.put("courseName",list1);
              map.put("avgscore",list2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(connection,statement,rs);
        }
        return  map;
    }

    @Override
    public List<AvgScore> queryAvg2() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<AvgScore> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select courses.courseName,avg(scores.score) as avgscore from courses,scores where scores.courseId = courses.id GROUP BY courses.courseName";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
              AvgScore avgscore  = new AvgScore(rs.getString("courseName"),rs.getString("avgscore"));
             list.add(avgscore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(connection,statement,rs);
        }
        return  list;
    }
}
