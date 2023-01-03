package com.kc.system.io;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/Demo");
        //创建新的空的文件
        System.out.println(file.createNewFile());
        //创建一级文件夹
         File file2 = new File("D:/test");
        System.out.println(file2.mkdir());
        //创建多级文件夹
        File file3 = new File("D:/test/C/C++");
        System.out.println( file3.mkdirs());
    }
}
