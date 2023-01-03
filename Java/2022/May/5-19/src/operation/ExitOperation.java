package operation;

import booklist.BookList;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 20:18
 */

public class ExitOperation implements IOperations {
    @Override
    public void work(BookList list) {
        System.exit(0);
        System.out.println("退出成功！");
    }
}
