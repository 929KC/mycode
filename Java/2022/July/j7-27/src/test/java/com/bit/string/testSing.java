package com.bit.string;

import org.junit.Test;

import java.io.Console;

public class testSing {
    @Test
    public  void testString(){
        //使用常量串构造
        String    s  = "hello";
        System.out.println(s);
        //newString对象
        String s2 = new String("world");
        System.out.println(s2);
        //使用字符数组进行构造
        char [] arr ={'a','b','c'};
        String s3 = new String(arr);
        System.out.println(s3);
    }

    @Test
    public void testString2(){
        String s1 = new String("hmr");
        String s2 = new String("hmr");
        String s3 = new String("yzq");
        String s4 = s1;
        System.out.println(s1==s3);
        System.out.println(s1 == s2);
        System.out.println(s4==s1);
    }
    @Test
    public void testString3(){
        String s1 = new String("hmr");
        String s2 = new String("hmr");
        String s3 = new String("yzq");
        String s4 = s1;
        System.out.println(s1.equals(s3));
        System.out.println(s1 .equals(s2));
        System.out.println(s4.equals(s1));
    }
    @Test
    public void testString4(){
        String s1 = new String("hmr");
        String s2 = new String("hmr");
        String s3 = new String("yzq");
        String s4 = s1;
        System.out.println(s1.compareTo(s2));
        System.out.println(s2 .compareTo(s3));
        System.out.println(s4.compareTo(s1));
    }
    @Test
    public void testString5(){
        String s1 = new String("HMR");
        String s2 = new String("hmr");
        String s3 = new String("YZQ");
        String s5 = new String("yzq");
        String s4 = s1;
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s2 .compareToIgnoreCase(s3));
        System.out.println(s4.compareToIgnoreCase(s1));
        System.out.println(s5.compareToIgnoreCase(s3));
    }

    @Test
    public void testString6(){
       String s1 = "hello";
       String s2 = "hello";
       System.out.println(s1==s2);
      String s3 = new String("hello");
      String s4 =new String ("hello");
      String s5 =new String("world");
      String s6 = "world";
      System.out.println(s6==s5);
      System.out.println(s3==s4);
    }

    @Test
    public void testString7(){
        char [] arr = new char[]{'a','b','c'};
        String s1 = new String(arr);
      //  s1.intern();
        String s2 = "abc";
        System.out.println(s1==s2);
    }



    @Test
    public void testString8(){
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0;i<10_0000;i++) {
            s+= i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    @Test
    public void testString9(){
        long start = System.currentTimeMillis();
        StringBuffer s = new StringBuffer("");
        for (int i = 0;i<10_0000;i++) {
           s.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    public   void testStringBuilder(){
        StringBuilder s= new StringBuilder("hello world");
        System.out.println(s.reverse().toString());

    }
}
