package com.bit.spring.Dao;

import org.springframework.stereotype.Repository;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 15:05
 */
@Repository(value = "usrDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void print() {
        System.out.println("我是UsrDaoImpl");
    }
}
