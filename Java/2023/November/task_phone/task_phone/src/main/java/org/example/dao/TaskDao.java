package org.example.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.model.Task;
import org.example.utils.DbHelp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TaskDao {
    public  static  void main(String[] args){
        new TaskDao().getTaskList().forEach(System.out::println);
    }

    public List<Task> getTaskList(){
        List<Task> taskList=null;
        Connection conn = DbHelp.getConnection();
        try {
            String sql = "select * from tb_task";
            QueryRunner qr = new QueryRunner();
            taskList = qr.query(conn, sql, new BeanListHandler<Task>(Task.class));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return taskList;
        }
    }

    /**
     * 根据手机号或编号取得维修信息
     * @param
     * @return
     */
    public Task getTaskByCodeAndPhone(String code) {
        Task task = null;
        Connection conn = DbHelp.getConnection();
        try {//ctrl+shift+上下
            QueryRunner qr = new QueryRunner();
            String sql = "select * from tb_task where cus_phone=? or task_no=?";
            task = qr.query(conn, sql, new BeanHandler<Task>(Task.class),code,code);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return task;
    }
}
