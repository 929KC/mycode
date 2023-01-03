package com.kc.shoping.mapper.impl;

import com.kc.shoping.mapper.UserMapper;
import com.kc.shoping.model.User;
import com.kc.shoping.utils.DBUtil;
import com.kc.shoping.vo.QueryUserVo;
import com.kc.shoping.vo.UserVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/12 9:59
 * @description:
 */
public class UserImpl implements UserMapper {
    @Override
    public int insetUser(UserVo userVo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int i = 0;
        try {
            String sql = "insert into T_user (name,trueName,cardId,email,telephone,qqId) values (?,?,?,?,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, userVo.getName());
            statement.setString(2, userVo.getTrueName());
            statement.setString(3, userVo.getCardId());
            statement.setString(4, userVo.getEmail());
            statement.setString(5, userVo.getTelephone());
            statement.setString(6, userVo.getQqId());
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
    public List<QueryUserVo> queryUserVo() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<QueryUserVo> list = null;
        try {
            String sql = "select *from T_user";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                QueryUserVo queryUserVo = new QueryUserVo();
                queryUserVo.setId(rs.getInt("id"));
                queryUserVo.setName(rs.getString("name"));
                int flag = rs.getInt("state");
                if (flag == 1) {
                    queryUserVo.setState("未被冻结");
                } else {
                    queryUserVo.setState("已被冻结");
                }
                list.add(queryUserVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;
    }

    @Override
    public User queryUser(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        User user = null;
        try {
            String sql = "select *from T_user where id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setTrueName(rs.getString("trueName"));
                user.setCardId(rs.getString("cardId"));
                user.setEmail(rs.getString("email"));
                user.setTelephone(rs.getString("telephone"));
                user.setRegTime(rs.getString("regTime"));
                user.setQuestion(rs.getString("question"));
                user.setAnswer(rs.getString("answer"));
                user.setQqId(rs.getString("qqId"));
                int flag = rs.getInt("state");
                if (flag == 1) {
                    user.setState("非冻结状态");
                } else {
                    user.setState("冻结状态");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return user;
    }
}
