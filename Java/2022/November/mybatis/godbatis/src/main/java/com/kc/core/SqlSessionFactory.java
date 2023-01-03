package com.kc.core;


import java.util.Map;

/**
 * @author 929KC
 * @date 2022/11/19 21:02
 * @description: 1.一个数据库库对应一个SqlSessionFactory对象
 * 2.通过SqlSessionFactory对象可以获取多个SqlSession
 * 3.一个SqlSessionFactory对象可以开启多个SqlSession会话
 */
public class SqlSessionFactory {
    /**
     *
     * @author 929KC
     * @date 2022/11/19 2022/11/19
     * @description: 事物管理器可以灵活切换,所以面向接口编程
     * @param null
     */
    private Transaction transaction;

    /**
     *
     * @author 929KC
     * @date 2022/11/19 2022/11/19
     *  @description: 存放sql语句的集合 key是SqlId value是对应的SQL标签信息对象
     * @param
     */
    private Map<String, MappedStatement> mapper;

    public SqlSessionFactory(Transaction transaction, Map<String, MappedStatement> mapper) {
        this.transaction = transaction;
        this.mapper = mapper;
    }

    public SqlSessionFactory() {

    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Map<String, MappedStatement> getMapper() {
        return mapper;
    }

    public void setMapper(Map<String, MappedStatement> mapper) {
        this.mapper = mapper;
    }
    public  SqlSession openSession() {
        transaction.openConnection();
        SqlSession SqlSession = new SqlSession(this);
        return SqlSession;
    }

}
