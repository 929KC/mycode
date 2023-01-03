package com.bit.java.io;

import java.io.File;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 18:18
 */

public class FileText {
    public static void main(String[] args) {
        File f=new File("D:\\file");
//        if(!f.exists()) {
//            try {
//                //创建文件
//                f.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //创建目录
//        File f2=new File("D:/a/b/c");
//        if(!f.exists()) {
//            f.mkdir();
//        }
//        if(!f2.exists()){
//            f2.mkdirs();
//        }

        File f3=new File("D:\\JavaSE工具\\Typora.zip");
        System.out.println(f3.getParent());
        File parentFile = f3.getParentFile();
        System.out.println(parentFile.getAbsolutePath());

    }
}
