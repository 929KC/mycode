package com.kc.system.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * PrintStream 继承自FilerOutStream
 */
public class PrintDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我为如来，又有何惧？");
        System.out.println("相遇皆是缘缘尽莫强求。");
        PrintStream ps = new PrintStream("bbb.txt");
        //改变语句的重定向
        System.setOut(ps);
        System.out.println("他宁愿死，也不肯输。");
        System.out.println("如来是什么，如是道来。");
    }
}
