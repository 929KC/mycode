package untis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelp {
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    private Connection conn=null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://120.78.166.85:3306/constructiondb?"
                    + "serverTimezone=UTC&&characterEncoding=utf8";
            String user="root";
            String pass="2222";

            conn=DriverManager.getConnection(url,user,pass);

            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet query(String sql,Object[] ob){
        Connection conn=getConnection();
        try {
            pst=conn.prepareStatement(sql);
            int i=1;
            if(ob!=null)
                for (Object object : ob) {
                    pst.setObject(i++, object);
                }
            rs=pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int update(String sql,Object[] ob){
        Connection conn=getConnection();
        int n=0;
        try {
            pst=conn.prepareStatement(sql);
            int i=1;
            if(ob!=null)
                for (Object object : ob) {
                    pst.setObject(i++, object);
                }
            n=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }    
    
    public void close(){
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(pst!=null)
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(conn!=null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}