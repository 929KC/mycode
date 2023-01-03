package com.kc.jsp.mapper.impl;

import com.kc.jsp.mapper.T_flow_step_defMapper;
import com.kc.jsp.model.T_flow_step_def;
import com.kc.jsp.utils.DBUtil;
import com.kc.jsp.vo.T_flow_step_defVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/9 9:02
 * @description:
 */
public class T_flow_step_defImpl implements T_flow_step_defMapper {
    @Override
    public int insert(T_flow_step_defVo t_flow_step_defVo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i = 0;
        try {
            String sql = "insert into t_flow_step_def(Step_name,Limit_time,Step_des,URL) values (?,?,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, t_flow_step_defVo.getStep_name());
            statement.setInt(2, t_flow_step_defVo.getLimit_time());
            statement.setString(3, t_flow_step_defVo.getStep_des());
            statement.setString(4, t_flow_step_defVo.getURL());
            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return i;
    }

    @Override
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i = 0;
        try {
            String sql = "delete from  t_flow_step_def where Step_no = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return i;
    }

    @Override
    public List<T_flow_step_def> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<T_flow_step_def> list = null;
        try {
            String sql = "select *from t_flow_step_def";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                T_flow_step_def t_flow_step_defVo = new T_flow_step_def(rs.getInt("Step_no"), rs.getString("Step_name"), rs.getInt("Limit_time"), rs.getString("Step_des"), rs.getString("URL"));
                list.add(t_flow_step_defVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;
    }
}
