package com.bit.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 09:59
 */

public class FileInputStreamText03 {
    public static void main(String[] args) {
        FileInputStream f=null;
        try {
            f=new FileInputStream("E:\\tet.txt");
            System.out.println("总字节数量："+f.available());
            byte[] bytes=new byte[f.available()];
            int reanCount=f.read(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(f!=null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
