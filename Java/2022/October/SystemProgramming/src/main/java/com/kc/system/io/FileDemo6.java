package com.kc.system.io;

import java.io.File;
import java.util.Arrays;

public class FileDemo6 {
    public static void main(String[] args) {
        File file = new File("D:/software");
        //获得该路径下文件的名称
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
        File file2 = new File("D:/software");
        //获得该路径下所有文件对象的抽象路径
        System.out.println(Arrays.toString(file2.listFiles()));
        File file4 = new File("D:/demo");
        //文件夹不存在时
        System.out.println(Arrays.toString(file4.listFiles()));
        //抽象路径为文件(不是文件夹)时
        File file5 = new File("D:/demo.txt");
        System.out.println(Arrays.toString(file5.listFiles()));
        //当文件夹为空时
        File file6 = new File("D:/test");
        System.out.println(Arrays.toString(file6.listFiles()));
    }
}
