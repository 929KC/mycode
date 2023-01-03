package com.bit.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:23
 */

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        FileInputStream f=null;
        f=new FileInputStream("D:\\io.txt");
        byte [] bytes=new byte[4];
        int count=0;
        while((count=f.read(bytes))!=-1){
            System.out.println(count);
        }
    }
}
