package user;

import operation.*;

import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 12:56
 */

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
      this.ip=new IOperations[]{
              new ExitOperation(),
              new SearchBook(),
              new BorrowBook(),
              new ReturnBook(),
      };
    }

    @Override
    public int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.name+"欢迎来到图书馆");
        System.out.println("1.查找图书：");
        System.out.println("2.借阅图书：");
        System.out.println("3.归还图书：");
        System.out.println("0.退出图书：");
        System.out.println("请输入你的选择：");
        int choice=sc.nextInt();
        return choice;
    }
}
