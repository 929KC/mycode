package com.kc.system.io;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        //定位到该绝对路径下的图片
        File f = new File("D:/picture/1.jpg");
        //输出文件的大小
        System.out.println(f.length());
        //使用相对路径定位到项目中的文件
        File file2 = new File("./bbb.txt");
        System.out.println(file2.length());
        File file3 = new File("D:/tools");
        System.out.println(file3.exists());
        System.err.println("ee");
    }
}
