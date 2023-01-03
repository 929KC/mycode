package com.bit.abnormal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestFinally {
    public static int getData() {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int data = sc.nextInt();
            return data;
        } catch (
                InputMismatchException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally中代码");
        }
        System.out.println("try-catch-finally之后代码");
        if (null != sc) {
            sc.close();
        }

        return 0;
    }

    public static void main(String[] args) {
        int data = getData();
        System.out.println(data);
    }
}