package com.bit.io;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:44
 */

public class FileReaderTest {
    public static void main(String[] args) throws Exception {
        FileReader reader = null;
        reader=new FileReader("D://io.txt");
        char[] buf=new char[4];
        int count=0;
        while ((count=reader.read(buf))!=-1){
            System.out.println(new String(buf,0,count));
        }
    }
}
