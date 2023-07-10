package org.example.stack;

import java.util.Arrays;

public class MyStack {
    private int[] element;
    private int useSize;
    private static final int capacity = 10;

    public MyStack() {
        element = new int[capacity];
    }

    private boolean isEmpty() {
        if (this.useSize == 0) {
            return false;
        }
        return true;
    }

    private boolean isFull() {
        if (this.useSize == this.element.length) {
            return false;
        }
        return true;
    }

    public int push(int element) {
        if (isFull()) {
            this.element = Arrays.copyOf(this.element,this.element.length*2);
        }
        return   this.element[this.useSize++] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        }
       int ret = peek();
       useSize--;
       return ret;
    }

    private int peek() {
        return this.element[this.useSize-1];
    }

    public int size() {
        return this.useSize;
    }

    public void traverse(){
        for (int i=this.useSize-1; i>=0; i--) {
            System.out.print(this.element[i]+" ");
        }
    }

}
