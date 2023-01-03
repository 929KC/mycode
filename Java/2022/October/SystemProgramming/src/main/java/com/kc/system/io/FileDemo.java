package com.kc.system.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        //将文件封装
        File file = new File("HelloWord.txt");
        //绝对路径
        System.out.println(file.getAbsoluteFile());
        //返回被修饰过的绝对路径
        System.out.println(file.getCanonicalFile());
        //判断是否为目录
        System.out.println(file.isDirectory());
        //判断是否为文件
        //若文件不存在则创建,创建成功后返回true
        System.out.println(file.createNewFile());
        //判断文件是否存在
        System.out.println(file.exists());
        //判断是否对文件有可读权限
        System.out.println(file.canRead());
        //判断是否对文件有可写权限
        System.out.println(file.canWrite());
        Thread.sleep(10000);
        file.deleteOnExit();
        System.out.println(file.exists());
        //删除该文件
        //System.out.println(file.delete());


    }
}
