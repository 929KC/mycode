package com.bit.bean;

import com.bit.dao.UserMapper;
import com.bit.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 22:11
 */

public class UserTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //一级缓存验证
        User user=mapper.queryUserById(5);
        System.out.println(user);
        sqlSession.close();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user2 = mapper1.queryUserById(5);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession1.close();
    }
}
