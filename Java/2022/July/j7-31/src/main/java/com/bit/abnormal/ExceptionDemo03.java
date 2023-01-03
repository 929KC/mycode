package com.bit.abnormal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo03 {
    public static void main(String[] args) {
        System.out.println("程序开始");
        try {
            parseTime("2022--08-01 09:23:60");
            System.out.println("功能操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("功能操作失败");
        }
        System.out.println("程序结束");
    }

    public static void parseTime(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        System.out.println(d);
    }
}
