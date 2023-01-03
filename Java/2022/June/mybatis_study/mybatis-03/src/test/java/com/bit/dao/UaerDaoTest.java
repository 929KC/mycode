package com.bit.dao;

import com.bit.bean.User;
import com.bit.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-12 10:27
 */

public class UaerDaoTest {
    @Test
        public void test(){
            //1.获取SqlSession对象
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            //2.执行SQL
            // 方式一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
            //关闭sqlSession
            sqlSession.close();
        }
        @Test
        public void   getUserById(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao user = sqlSession.getMapper(UserDao.class);
            User userById = user.getUserById(4);
            System.out.println(userById);
            sqlSession.close();
        }
        @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao user = sqlSession.getMapper(UserDao.class);
        User u=new User(4,"林黛玉","04");
        int i = user.addUser(u);
        if(i>0){
            System.out.println("添加成功");
        }
        //增删改需提交事物
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
       mapper.updateUser(new User(4,"花无缺","04"));
       sqlSession.commit();
       sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
       mapper.deleteUser(3);
        sqlSession.commit();
        sqlSession.close();
    }
}
