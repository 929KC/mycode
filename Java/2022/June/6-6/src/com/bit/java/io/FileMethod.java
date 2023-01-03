package com.bit.java.io;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 18:38
 */

public class FileMethod {
    public static void main(String[] args) {
//        File f=new File("log.txt");
//        //获取文件名
//        System.out.println("文件名："+f.getName());
//        //判断是否是目录
//        System.out.println(f.isDirectory());
//        //判断是否是一个文件
//        System.out.println(f.isFile());
//        //获取文件最后的修改日期
//        long time=f.lastModified();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        String lastTime=sdf.format(time);
//        System.out.println(lastTime);
        //获取文件的大小
       // System.out.println(f.length());
        File f4=new File("D:\\Git");
        File [] files=f4.listFiles();
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }

    }
}
