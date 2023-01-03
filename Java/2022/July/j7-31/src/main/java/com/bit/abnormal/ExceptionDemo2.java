package com.bit.abnormal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo2 {
    public static void main(String[] args) throws ParseException {
       fun();
    }

    public static  void fun() throws ParseException {
        String date = "2022-08-01 8:25:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        System.out.println(d);
    }
}
