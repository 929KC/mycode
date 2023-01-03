package operation;

import book.Book;
import booklist.BookList;
import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 13:13
 */

public class AddBook implements IOperations {

    @Override
    public void work(BookList list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要新增的书名：");
        String name = sc.next();
        System.out.println("请输入你要新增图书的作者：");
        String author = sc.next();
        System.out.println("请输入书的价格");
        int price = sc.nextInt();
        System.out.println("请输入你要新增图书的类型：");
        String type = sc.next();
        Book book = new Book(name, author, price, type);
        int currentSize = list.getUserSized();
        list.setBooks(currentSize, book);
        list.setUserSized(currentSize + 1);
        System.out.println("添加成功");
    }

}
