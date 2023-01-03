package com.bit.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 11:13
 */

public class Copy {
    public static void main(String[] args) {
        FileInputStream in=null;
        FileOutputStream out=null;
        try {
            //创建一个输入流对象
            in=new FileInputStream("E:\\tet.txt");
            //创建一个输出流对象
            out=new FileOutputStream("E:\\tet2.txt");
            byte [] bytes=new byte[1024*1024];//1M
            int read=0;
            while ((read=in.read(bytes))!=-1) {
                out.write(bytes,0,read);
            }
            //刷新,输出流刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
