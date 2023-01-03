package com.bit.abnormal;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        try {
            int[] array = {1,2,3};
            System.out.println(array[3]);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }
}
