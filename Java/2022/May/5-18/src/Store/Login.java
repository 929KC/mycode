package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	static SQLHelp  help = new SQLHelp();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===========用户登录=============");
		Scanner in = new Scanner(System.in);
		System.out.print("用户名：");
		String luser = in.nextLine();
		System.out.print("密码：");
		String lpwd = in.nextLine();

		String sql = "SELECT COUNT(*) FROM t_users WHERE loginuser=? AND loginpwd=?";//参数化SQL语句
		Object[] parpam = new Object[2];
		parpam[0] = luser;
		parpam[1] = lpwd;
		ResultSet rs = help.getParamQuery(sql, parpam);
		try {
			rs.next();
			int n = rs.getInt(1);
			if(n>0){
				System.out.println("登录成功！");

				sql = "SELECT * FROM t_goods";
				getResult(sql);
			}
			else{
				System.out.println("登录失败！账号或密码错误！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void getResult(String sql){
		help = new SQLHelp();
		ResultSet rs1 = help.getQuery(sql);
		System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t商品类别\t\t商品数量\t\t备注信息");
		System.out.println("------------------------------------------------------------------------------------------");
		try {
			while(rs1.next()){
				System.out.print(rs1.getInt(1)+"\t\t");
				System.out.print(rs1.getString(2)+"\t\t");
				System.out.print(rs1.getFloat(3)+"\t\t");
				System.out.print(rs1.getString(4)+"\t\t");
				System.out.print(rs1.getInt(5)+"\t\t");
				System.out.println(rs1.getString(6)+"\t\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addGood(){

	}
}
