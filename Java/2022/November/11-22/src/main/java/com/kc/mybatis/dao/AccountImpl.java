package com.kc.mybatis.dao;

import com.kc.mybatis.dao.impl.AccountMapper;
import com.kc.mybatis.model.Account;
import com.kc.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 929KC
 * @date 2022/11/21 18:52
 * @description:
 */
public class AccountImpl implements AccountMapper {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Account account =(Account) sqlSession.selectOne("selectByActno", actno);
        sqlSession.close();
        return account;
    }

    @Override
    public int update(Account act) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int count = sqlSession.update("update", act);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
