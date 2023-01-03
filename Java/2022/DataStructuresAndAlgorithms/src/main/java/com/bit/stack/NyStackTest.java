package com.bit.stack;

public class NyStackTest {
    public static void main(String[] args) {
        MyStack ms=new MyStack();
        ms.push(11);
        ms.push(12);
        ms.push(13);
        ms.push(14);
        ms.push(15);
        ms.push(16);
        System.out.println(ms.size());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        ms.traverse();

    }
}
