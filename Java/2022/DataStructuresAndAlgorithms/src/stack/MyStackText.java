package stack;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-26 11:52
 */

/**
 * 顺序表实现
 */
public class MyStackText {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        myStack.push(14);
        myStack.push(15);
        System.out.println(myStack.size());
        myStack.list();

    }
}
