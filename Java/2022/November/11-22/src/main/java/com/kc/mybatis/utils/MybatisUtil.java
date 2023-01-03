package com.kc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


/**
 *
 * @author 929KC
 * @date 2022/11/21 2022/11/21
 * @decription: 获取SqlSession
 */

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
      SqlSessionFactoryBuilder sqlSessionBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @author 929KC
     * @date 2022/11/21 2022/11/21
     * @decription: 每一次调用该方法都会获得一个新的SqlSession,参数设置
     * @return SqlSession
     */

    public static SqlSession getSqlSession(){
        //openSession 的参数为true自动提交事物
        return sqlSessionFactory.openSession(true);
    }
}
