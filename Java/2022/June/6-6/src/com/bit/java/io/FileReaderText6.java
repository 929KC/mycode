package com.bit.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 11:48
 */

public class FileReaderText6 {
    public static void main(String[] args) {
        FileReader reader=null;
        try {
            reader=new FileReader("E:\\tet.txt");
            char[] chars=new char[4];
            int readCount=0;
            while ((readCount=reader.read(chars))!=-1){
                System.out.print(new String(chars,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
