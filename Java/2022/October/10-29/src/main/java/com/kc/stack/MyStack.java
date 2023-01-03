package com.kc.stack;


import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    private int [] elementData;
    private int size;
    private static final int CAPACITY  = 5;

    public MyStack() {
        this.elementData = new int[CAPACITY];
        this.size = 0;
    }

    public int push(int element){
        ensureCapacity();
        this.elementData[size++] = element;
        return element;
    }

    public int peek(){
        if (isEmpty()){
            throw  new RuntimeException("栈为空");
        }
        return this.elementData[size-1];
    }

    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈为空");
        }
        int ret = peek();
        this.size--;
        return ret;
    }

    public boolean isEmpty() {
        if (this.size==0) {
            return true;
        }
        return false;
    }


    private void ensureCapacity() {
        if (this.size==this.elementData.length){
            this.elementData = Arrays.copyOf(this.elementData,this.elementData.length*2);
        }
    }

    public int size(){
        return size;
    }

   public int search(int element){
        int index = lastIndexOf(element);
        if (index>=0) {
            return this.size()-index;
        }
        return -1;
   }

    private int lastIndexOf(int element) {
        for (int i=this.elementData.length-1;i>=0;i--) {
            if (this.elementData[i]==element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
