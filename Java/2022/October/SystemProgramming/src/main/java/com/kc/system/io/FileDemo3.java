package com.kc.system.io;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo3 {
    public static void main(String[] args) {
        File  file = new File("D:\\game");
        //判断是否为文件
        System.out.println(file.isFile());
        //判断是否为文件夹
        System.out.println(file.isDirectory());
        //判断该文件存在
        System.out.println(file.exists());
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获得该路径表示的文件或者文件夹的名称
        System.out.println(file.getName());
        //将该路径转换成字符串
        System.out.println(file.getPath());
        //返回文件最后的修改时间
        System.out.println(  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(file.lastModified()));
    }
}
