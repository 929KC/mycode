package com.kc.core;

import java.sql.Connection;

/**
 * @author: 929KC
 * @date 2022/11/19 21:59
 * @description: 事物管理器接口
 * @version: 0.0.1
 **/
public interface Transaction {
    void rollback();
    void commit();;
    void  close();
    void openConnection();
    Connection getConnection();
}
