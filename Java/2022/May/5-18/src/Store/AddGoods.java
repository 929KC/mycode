package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddGoods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("===========添加商品=============");
		System.out.print("商品编号：");
		int goodid = in.nextInt();
		System.out.print("商品名称：");
		String goodName = in.next();
		System.out.print("商品价格：");
		float price = in.nextFloat();
		System.out.print("商品类型：");
		String type = in.next();
		System.out.print("商品数量：");
		int num = in.nextInt();
		System.out.print("其他信息：");
		String memo = in.next();

		SQLHelp help = new SQLHelp();
		String sql = "INSERT INTO t_goods VALUES(?,?,?,?,?,?)";
		Object[] parpam1 = new Object[6];
		parpam1[0] = goodid;
		parpam1[1] = goodName;
		parpam1[2] = price;
		parpam1[3] = type;
		parpam1[4] = num;
		parpam1[5] = memo;
		help.getparamUpdate(sql, parpam1);

	}

}
