package com.kc.system.io;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtilsDemo {
    public static void main(String[] args) throws IOException {
        //完成文件的复制
        IOUtils.copy(new FileInputStream("./bbb.txt"), new FileOutputStream("./bbb2.txt"));
        //完成文件复制到某个文件夹下
        FileUtils.copyFileToDirectory(new File("D:/picture/1.jpg"),new File("D:/tools"));
        //完成文件夹复制到某个文件夹下
        FileUtils.copyDirectoryToDirectory(new File("D:/picture"),new File("D:/tools"));
        //读取文件中的数据
        String str = FileUtils.readFileToString(new File("./bbb.txt"),"UTF-8");
        System.out.println(str);
        //复制文件
        FileUtils.copyFile(new File("./bbb.txt"),new File("./bbb3.txt"));
        //删除文件夹
        FileUtils.deleteDirectory(new File("D:/demo"));
    }
}
