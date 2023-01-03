package com.bit.java.io;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 11:37
 */

public class FileReaderText5 {
    public static void main(String[] args) {
        FileReader reader=null;
        try {
            reader=new FileReader("E:\\tet.txt");
            int readCount=0;
           char [] chars=new char[4];
        /*   while ((readCount=reader.read(chars))!=-1){
               System.out.print(new String(chars,0,readCount));
           }*/
            reader.read(chars);
            for (char Char : chars) {
                System.out.println(Char);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
