import booklist.BookList;
import user.NormalUser;
import user.RootUser;
import user.User;

import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 20:50
 */

public class Start {
    public static void main(String[] args) {
        User use=login();
        BookList list=new BookList();
        while (true){
            int chiose=use.menu();
            use.doOperation(chiose,list);
        }
    }

    private static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.next();
        System.out.println("情输入你的身份：1-》管理员,0-》普通用户");
        int id = sc.nextInt();
        if (id == 1) {
            return new RootUser(name);
        } else {
            return new NormalUser(name);
        }
    }
}
