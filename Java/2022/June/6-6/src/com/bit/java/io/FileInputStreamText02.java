package com.bit.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 09:42
 */

/**
 * available();返回流中剩余的没有读到的字节数量
 * skip();跳过几个字节不读
 */
public class FileInputStreamText02 {
    public static void main(String[] args) {
        FileInputStream f=null;
        try {
            f=new FileInputStream("E:\\tet.txt");
            byte [] bytes=new byte[4];
            int read=0;
//            while (true){
//                read=f.read(bytes);
//                if(read!=-1){
//                    System.out.print(new String(bytes,0,read));
//                }
//            }
            f.skip(10);
            while((read=f.read(bytes))!=-1){
                System.out.print(new String(bytes,0,read));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
