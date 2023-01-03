package com.kc.core;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 929KC
 * @date 2022/11/20 7:34
 * @description:
 */
public class JdbcTransaction implements Transaction{
    private DataSource dataSource;
    private boolean autoCommit;
    private Connection connection;

    public JdbcTransaction(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void openConnection()  {
        if (connection==null) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
