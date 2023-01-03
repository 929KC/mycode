package Store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static ResultSet rs;
	public static SQLHelp help;

	public static void main(String[] args) {
	
		System.out.println("**************商品管理系统**************");
		System.out.println("1 添加商品");
		System.out.println("2 显示所有商品信息");
		System.out.println("3 根据类别查找商品");
		System.out.println("4 修改商品信息");
		System.out.println("5 根据商品编号删除商品");
		System.out.println("6 查询指定商品的总价");
		System.out.println("7 按商品价格排序");
		System.out.println("8 退出");
		System.out.println("****************************************");

		Scanner in = new Scanner(System.in);
		int choose = in.nextInt();
		String sql ="";
		SQLHelp help = new SQLHelp();

		switch (choose) {
			case 1:
				//1 添加商品  --     修改
				System.out.println("请输入新商品的信息：");
				System.out.print("商品编号：");
				int newNo = in.nextInt();
				System.out.print("商品名称：");
				String newName = in.next();
				System.out.print("价格：");
				float nprice = in.nextFloat();
				System.out.print("类别：");
				String nType = in.next();
				System.out.print("数量：");
				int num = in.nextInt();
				System.out.print("备注：");
				String memo = in.next();

				sql = "INSERT INTO t_goods VALUES("+newNo+",'"+newName+"',"+nprice+",'"+nType+"',"+num+",'"+memo+"')";
				help.getUpdate(sql);
				break;
			case 2:
				//2 显示所有商品信息 -- 查询
				sql = "SELECT * FROM t_goods";
				getResult(sql);
				break;
			case 3:
				//3 根据类别查找商品  -- 查询
				System.out.println("请输入要查找的类别：");
				String stype = in.next();
				sql = "SELECT * FROM t_goods WHERE type='"+stype+"'";
				getResult(sql);
				break;
			case 4:
				//4 修改商品信息  ---   修改
				System.out.println("请输入修改商品的信息：");
				System.out.print("商品编号：");
				int uNo = in.nextInt();
				System.out.print("商品名称：");
				String uName = in.next();
				System.out.print("价格：");
				float uprice = in.nextFloat();
				System.out.print("数量：");
				int unum = in.nextInt();

				sql ="UPDATE t_goods SET goodname='"+uName+"',price="+uprice+",number="+unum+" WHERE goodid="+uNo;
				help.getUpdate(sql);
				break;
			case 5:
				//5 根据商品编号删除商品 -- 修改
				System.out.print("请输入要删除的商品编号：");
				int dNo = in.nextInt();
				sql = "DELETE FROM t_goods WHERE goodid="+dNo;
				help.getUpdate(sql);
				break;
			case 6:
				//6 查询指定商品的总价  -- 查询
				System.out.print("请输入要查询的商品名称：");
				String pName = in.next();
				sql = "SELECT goodname, price*number FROM t_goods WHERE goodname like '%"+pName+"%'";
				ResultSet rs = help.getQuery(sql);
				try {
					rs.next();
					String dName = rs.getString(1);
					double total = rs.getFloat(2);

					System.out.println(dName+"的总价格："+total+"元");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 7:
				//7 按商品价格排序  ---  查询
				sql = "SELECT * FROM t_goods ORDER BY price";
				getResult(sql);
				break;
			case 8:
				//8 退出
				System.out.println("欢迎下次使用！");
				break;
			default:
				//用户选择错误
				System.out.println("没有你选择的选项！");
				break;
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

}
