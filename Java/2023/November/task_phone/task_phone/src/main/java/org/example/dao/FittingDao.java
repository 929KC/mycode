package org.example.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.model.Fitting;
import org.example.utils.DbHelp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class FittingDao {
    public List<Fitting> getFittingList() {
        List<Fitting> list = null;
        QueryRunner qr = new QueryRunner();
        String sql = "select * from tb_fittings";
        Connection conn = DbHelp.getConnection();
        try {
            list = qr.query(conn, sql, new BeanListHandler<Fitting>(Fitting.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     *
     * @param fit_id
     * @return
     */
    public Fitting getFitting(int fit_id) {
        Fitting fitting = null;
        QueryRunner qr = new QueryRunner();
        String sql = "select * from tb_fittings where fit_id=?";
        Connection conn = DbHelp.getConnection();
        try {
            fitting = qr.query(conn,sql,new BeanHandler<Fitting>(Fitting.class),fit_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fitting;
    }

    public static void main(String[] args) {
        FittingDao fittingDao = new FittingDao();
        Fitting fitting = fittingDao.getFitting(1);
        System.out.println(fitting);
        List<Fitting> fittingList = fittingDao.getFittingList();
        fittingList.forEach(System.out::println);
    }
}
