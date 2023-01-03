package operation;

import booklist.BookList;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 13:15
 */

public class ShowBook implements IOperations {
    @Override
    public void work(BookList list) {
        System.out.println("显示图书：");
        for(int i=0;i<list.getUserSized();i++){
            System.out.println(list.getBook(i));
        }
    }
}
