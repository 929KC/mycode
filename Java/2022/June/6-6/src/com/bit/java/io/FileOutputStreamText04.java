package com.bit.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 10:25
 */

public class FileOutputStreamText04 {
    public static void main(String[] args) {
        FileOutputStream f =null;
        try {
           // f=new FileOutputStream("myfile");会清空源文件在写入
            f=new FileOutputStream("myfile",true);//不会清空原文件,直接在源文件的后面直接追加
            byte[] bytes =new byte[]{97,98,99,100,101};
            f.write(bytes);
            f.write(bytes,0,2);
            String s="我是一个java程序员";
            byte[] bytes1 = s.getBytes();
            f.write(bytes1);
            f.flush();
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
