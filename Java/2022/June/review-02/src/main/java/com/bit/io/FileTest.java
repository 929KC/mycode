package com.bit.io;
import java.io.File;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 08:32
 */

public class FileTest {
    public static void main(String[] args) throws Exception {
//        File f=new File("D://io5.txt");
//        if(!f.exists()) {
//            f.createNewFile();
//        }
//        File f=new File("D:/a/b/c");
//        if(!f.exists()) {
//            f.mkdirs();
//        }


//        File f=new File("D:\\maven\\apache-maven-3.6.3");
//        File parentFile = f.getParentFile();
//        System.out.println(parentFile);
        File f=new File("D:\\工具");
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

    }
}
