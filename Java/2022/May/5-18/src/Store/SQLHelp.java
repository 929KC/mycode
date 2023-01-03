package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//访问sql的工具类

public class SQLHelp {
	private Connection cn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement prestmt;

	//方法1：创建数据库连接对象
	public void getConnection(){
		try {
			//1、创建驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、创建连接
			String url = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC";
			String user = "root";
			String password = "mysql";
			cn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//方法2：创建SQL语句执行对象
	public void getStatement(){
		try {
			//1、2、
			getConnection();
			//3、
			stmt = cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//方法3：执行查询SQL语句
	public ResultSet getQuery(String sql){
		try {
			//1\2\3:获得sql执行对象
			getStatement();
			//执行查询语句
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	//方法4：执行增删改SQL语句
	public void getUpdate(String sql){

		try {
			//1\2\3:获得sql执行对象
			getStatement();
			//执行增删改语句
			int n = stmt.executeUpdate(sql);
			if(n>0){
				System.out.println("操作成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//方法5：在属性不为空的情况下关闭与数据库的连接
	public void dbclose(){
		try {
			if(rs!=null)
				rs.close();

			if(stmt!=null)
				stmt.close();

			if(cn!=null)
				cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//6:创建预处理的statement对象
	public void getPreStatement(String sql){
		getConnection();
		try {
			prestmt = cn.prepareStatement(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7：执行带参数的SQL查询语句
	public ResultSet getParamQuery(String sql,Object[] params){
		getPreStatement(sql);
		try {
			for(int i=1;i<=params.length;i++){
				prestmt.setObject(i, params[i-1]);
			}
			rs = prestmt.executeQuery();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	//8：执行带参数的增删改SQL语句
	public void getparamUpdate(String sql,Object[] params){
		getPreStatement(sql);
		try {
			for(int i=1;i<=params.length;i++){
				prestmt.setObject(i, params[i-1]);
			}
			int n = prestmt.executeUpdate();
			if(n>0){
				System.out.println("操作成功！");
			}
			else {
				System.out.println("操作失败！");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
