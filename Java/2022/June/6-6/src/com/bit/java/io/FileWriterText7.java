package com.bit.java.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 11:52
 */

/**
 * 字符流只能读普通文本
 */
public class FileWriterText7 {
    public static void main(String[] args) {
        FileWriter out=null;
        try {
            out=new FileWriter("myfile2",true);
            char [] chars=new char[]{'q','s','e','f','g'};
            out.write(chars);
            out.write(chars,0,2);
            String s="我是一个java程序员";
            char[] chars1 = s.toCharArray();
            out.write(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
