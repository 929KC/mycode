package com.bit.abnormal;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[4]);
            System.out.println("after");
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
