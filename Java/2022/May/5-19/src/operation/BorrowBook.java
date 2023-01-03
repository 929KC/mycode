package operation;

import book.Book;
import booklist.BookList;

import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 20:20
 */

public class BorrowBook implements IOperations {
    @Override
    public void work(BookList list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要借的书名：");
        String name = sc.next();
        for(int i=0;i<list.getUserSized();i++){
            Book book=list.getBook(i);
            if(name.equals(book.getName())){
                book.setBorrow(true);
                System.out.println("已成功借书");
                return ;
            }
        }

    }
}
