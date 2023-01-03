package com.bit.list;

import org.junit.Test;

public class Pack {

    public static void main(String[] args) {
            int  a = 90;
            Integer b = a;
           System.out.println(b);
    }
    @Test
    public  static  void  test(){
        //基本类型转字符串
        int a = 90;
        String s = Integer.toString(a);
        System.out.println(s);
        //字符串转基本类型
        int i = Integer.parseInt(s);
        System.out.println(i);
    }
}
