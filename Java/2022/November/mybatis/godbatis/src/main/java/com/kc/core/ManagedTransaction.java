package com.kc.core;

import java.sql.Connection;

/**
 * @author 929KC
 * @date 2022/11/20 7:35
 * @description:
 */
public class ManagedTransaction implements Transaction{
    @Override
    public void rollback() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void close() {

    }

    @Override
    public void openConnection() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
