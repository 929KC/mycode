package com.kc.system.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputStream3 {
    public static void main(String[] args) throws FileNotFoundException {
        // 1、创建一个文件字节输入流管道与源文件接通
        File f = new File("file-io-app/src/data03.txt");
        InputStream is = new FileInputStream(f);
        // 读取全部字节数    System.out.println(new String(buffer));
    }
}
