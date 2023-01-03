package com.bit.generic;

public class TestDemo {
    public static void main(String[] args) {
        Message<Integer> message = new Message();
        message.setMessage(110);
        fun(message);
    }

    public static void fun(Message<?>temp) {
        System.out.println(temp.getMessage());
    }
}