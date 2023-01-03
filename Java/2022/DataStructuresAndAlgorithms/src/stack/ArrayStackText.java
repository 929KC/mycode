package stack;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-26 10:32
 */

public class ArrayStackText {
    public static void main(String[] args) {
        ArrayStack myStack = new ArrayStack(4);
 /*       myStack.push(12);
        myStack.push(13);
        myStack.push(14);
        myStack.push(15);
        myStack.list();*/
        Scanner sc = new Scanner(System.in);
        String key=" ";
        boolean flag=true;
        while (flag){
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("list:遍历栈");
            System.out.println("getLen:遍历栈");
            System.out.println("exit:结束程序");
            System.out.println("请输入你要选项：");
            key=sc.next();
            switch (key){
                case "push":
                    System.out.println("请输入你要posh的数：");
                    int num=sc.nextInt();
                    myStack.push(num);
                    break;
                case "pop":
                    System.out.println("请输入你要pop的数：");
                    int num2=sc.nextInt();
                    myStack.push(num2);
                    break;
                case "list":
                  myStack.list();
                    break;
                case "getLen":
                    System.out.println("栈长："+myStack.getLen());
                    break;
                case "exit":
                    sc.close();
                    flag=false;
                    System.out.println("程序结束！");
                    break;
                default:
                    System.out.println("你输入的有误");
                    break;
            }
        }
    }
}
