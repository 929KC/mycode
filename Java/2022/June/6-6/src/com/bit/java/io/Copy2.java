package com.bit.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 11:59
 */

public class Copy2 {
    public static void main(String[] args) {
        FileReader in=null;
        FileWriter out=null;
        try {
            //创建字符输入流
            in=new FileReader("E:\\tet.txt");
            //创建字符输出流
            out=new FileWriter("E:\\tet3.txt");
            char [] chars=new char[1024*1024];
            int readCount=0;
            while ((readCount=in.read(chars))!=-1){
            out.write(chars,0,readCount);
            }
           out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
