package com.kc.system.io;

import java.io.*;

/**
 * PrintWriter 继承Writer
 * PrintStream 继承自FilerOutStream
 */
public class PrintDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //可追加数据
//        PrintStream ps= new PrintStream(new FileOutputStream("bbb.txt",true));
//        ps.println("Hello World");
//        ps.print("今天是10月25日");
//        ps.print('a');
//        ps.close();
        PrintWriter pw= new PrintWriter("bbb.txt");
        pw.println("今天天气真好");
        pw.println(12);
        pw.println(12.09);
        pw.println('a');
        pw.println(true);
        pw.println(97);
        pw.close();
    }
}
