package operation;

import book.Book;
import booklist.BookList;

import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 20:12
 */

public class ReturnBook implements IOperations {
    @Override
    public void work(BookList list) {
        System.out.println("归还图书");
        Scanner sc = new Scanner(System.in);
        System.out.println("情书输入你要归还图书的书名：");
        String name = sc.next();
        int currentSize= list.getUserSized();
        for(int i=0;i<currentSize;i++){
            Book book = list.getBook(i);
            if(name.equals(book.getName())){
                book.setBorrow(false);
                System.out.println("归还成功");
                return ;
            }
        }

    }

}
