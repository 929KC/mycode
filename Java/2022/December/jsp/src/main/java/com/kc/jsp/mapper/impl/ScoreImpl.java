package com.kc.jsp.mapper.impl;

import com.kc.jsp.mapper.ScoreMapper;
import com.kc.jsp.model.AvgScore;
import com.kc.jsp.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/8 14:32
 * @description:
 */
public class ScoreImpl implements ScoreMapper {

    @Override
    public List<AvgScore> queryAvg() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<AvgScore> list = new ArrayList<AvgScore>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select courses.courseName,avg(scores.score) as avgscore from courses,scores where scores.courseId = courses.id GROUP BY courses.courseName";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                AvgScore avgscore = new AvgScore(rs.getString("courseName"), rs.getString("avgscore"));
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
