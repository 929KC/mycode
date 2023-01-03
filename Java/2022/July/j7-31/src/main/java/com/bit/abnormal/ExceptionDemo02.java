package com.bit.abnormal;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo02 {
    public static void main(String[] args) {
        System.out.println("程序开始");
        parseTime("2022-08-01 9:06:30");
        System.out.println("程序结束");
    }

    public static void parseTime(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse(date);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常栈信息
        }
    }
}