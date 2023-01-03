package com.kc.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;


/**
 * @author 929KC
 * @date 2022/11/21 7:47
 * @description:
 */
public class SqlSession {
    private SqlSessionFactory factory;

    public SqlSession(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public  int insert(String sqlId,Object pojo) {
        int count = 0;
        try{
            Connection connection = factory.getTransaction().getConnection();
            String godbatisSql = factory.getMapper().get(sqlId).getSql();
            String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}","?");
            PreparedStatement ps = connection.prepareStatement(sql);
            int fromIndex = 0;
            int index = 0;
            while(true) {
                int leftIndex = godbatisSql.indexOf("#",fromIndex);
                if (leftIndex<0) {
                    break;
                }
                int  rightIndex = godbatisSql.indexOf("}",fromIndex);
                String propertyName = godbatisSql.substring(leftIndex+2,rightIndex).trim();
                String getMethodName = "get"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);
                Object propertyValue = getMethod.invoke(pojo);
                ps.setString(index,propertyValue.toString());
                index++;
            }
        count = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public Object selectOne(String  sqlId,Object param) {
        Object object = null;
        MappedStatement godMappedStatement = factory.getMapper().get(sqlId);
        Connection connection = factory.getTransaction().getConnection();
        // 获取sql语句
        String godbatisSql = godMappedStatement.getSql();
        String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_\\$]*}", "?");
        // 执行sql
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, param.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                // 将结果集封装对象，通过反射
                String resultType = godMappedStatement.getResultType();
                Class<?> aClass = Class.forName(resultType);
                Constructor<?> con = aClass.getDeclaredConstructor();
                obj = con.newInstance();
                // 给对象obj属性赋值
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    String setMethodName = "set" + columnName.toUpperCase().charAt(0) + columnName.substring(1);
                    Method setMethod = aClass.getDeclaredMethod(setMethodName, aClass.getDeclaredField(columnName).getType());
                    setMethod.invoke(obj, rs.getString(columnName));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return obj;
    }


    public void commit(){
        factory.getTransaction().commit();
    }
    public  void close(){
        factory.getTransaction().close();
    }
    public void rollback(){
        factory.getTransaction().rollback();
    }

}
