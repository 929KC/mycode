package com.bit.abnormal;

public class ExceptionDemo5 {
    public static void main(String[] args) {
            fun();
        System.out.println("Hello World");
    }

    public static  void fun(){
        int [] arr ={1,2,3,4,5};
        System.out.println(arr[1000]);
    }
}
