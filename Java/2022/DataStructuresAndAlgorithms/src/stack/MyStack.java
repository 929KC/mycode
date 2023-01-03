package stack;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-26 11:52
 */

public class MyStack {
    private int userSized;
    private int ArrayStack[];
    private static final int maxSize = 10;

    public MyStack() {
        this.userSized = 0;
        this.ArrayStack = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.userSized == 0;
    }

    public boolean isFull() {
        if (this.userSized == this.maxSize) {
            return true;
        }
        return false;
    }

    //入栈
    public void push(int value) {
        if(isFull()){
            this.ArrayStack= Arrays.copyOf(this.ArrayStack,2*ArrayStack.length);
        }
        ArrayStack[userSized++]=value;
    }

    //出栈
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return ArrayStack[userSized--];
    }

    //查看栈顶的元素元素
    public int peek() {
        return ArrayStack[userSized--];
    }

    //栈的大小
    public int size() {
        return userSized;
    }
    //遍历栈
    public void list(){
        for(int i=userSized-1;i>=0;i--){
            System.out.printf("ArraysStack[%d]=%d\n",i, ArrayStack[i]);
        }
    }
}
