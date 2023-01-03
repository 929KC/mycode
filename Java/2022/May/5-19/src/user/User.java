package user;

import booklist.BookList;
import operation.IOperations;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 13:15
 */

public abstract class User {
   protected String name;
    protected IOperations [] ip;
    public abstract int menu();
    public User(String name){
        this.name=name;
    }
    public void doOperation(int choice, BookList List){
        this.ip[choice].work(List);
    }
}
