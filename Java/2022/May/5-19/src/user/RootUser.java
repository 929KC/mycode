package user;

import operation.*;

import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 12:57
 */

public class RootUser extends User {

    public RootUser(String name) {
        super(name);
        this.ip = new IOperations[]{
                new ExitOperation(),
                new SearchBook(),
                new AddBook(),
                new DeleteBook(),
                new ShowBook()
        };
    }

    @Override
    public int menu() {
        System.out.println(this.name + "欢迎来到图书馆");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.查找图书：");
        System.out.println("2.新增图书：");
        System.out.println("3.删除图书：");
        System.out.println("4.显示图书：");
        System.out.println("0.退出图书：");
        System.out.println("请输入你的选择：");
        int choice = sc.nextInt();
        return choice;
    }
}
