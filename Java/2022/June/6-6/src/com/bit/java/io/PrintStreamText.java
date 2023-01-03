package com.bit.java.io;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 13:59
 */

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 标椎的字节输出流,默认输出到控制台
 * 不需要关闭
 */
public class PrintStreamText {
    public static void main(String[] args) throws Exception {
        PrintStream ps = System.out;
        ps.println("Hello World");
        //标准输出流不再指向控制台,执行log文件
        PrintStream p=new PrintStream(new FileOutputStream("log"));
        //修改输出方向,将输出的方向修改到log
        System.setOut(p);
        System.out.println("你好");
        System.out.println("我是黄茂荣");
        System.out.println("今年19岁");
    }
}
