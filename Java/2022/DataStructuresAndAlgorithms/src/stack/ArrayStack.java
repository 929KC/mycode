package stack;


import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-26 10:29
 */

public class ArrayStack {
    private int stack[];
    private int maxSize;//栈的最大容量
    private int top = -1;//栈顶

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {

        if ( top == maxSize - 1){
           return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
    if(isFull()){
        //throw  new RuntimeException("栈满无法添加");
        this.stack= Arrays.copyOf(this.stack, 2*maxSize);
    }
    top++;
    stack[top] =value;
    }

    //出栈
    public int  pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int ret=stack[top];
        top--;
        return ret;
    }

    //遍历栈
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }

        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //求栈的长度
    public int getLen(){
        return this.stack.length;
    }

}
