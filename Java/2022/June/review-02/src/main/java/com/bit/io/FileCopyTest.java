package com.bit.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:36
 */

public class FileCopyTest {
    public static void main(String[] args) throws Exception {
       FileInputStream fi=null;
       FileOutputStream fo=null;
       fi=new FileInputStream("D://io.txt");
       fo=new FileOutputStream("D://io2.txt");
       byte[] bytes=new byte[1024*1024];
       int count=0;
       while ((count=fi.read(bytes))!=-1){
           fo.write(bytes,0,count);
       }
       fo.flush();
    }
}
