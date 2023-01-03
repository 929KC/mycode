package com.bit.java.io;

import java.io.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 13:28
 */

public class BufferedWriterText3 {
    public static void main(String[] args) {
        BufferedWriter out = null;
        try {
            //out = new BufferedWriter(new FileWriter("myfile3"));
           out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myfile3")));
            out.write("Hello World");
            out.write("\n");
            out.write("我是一个java程序员");
            out.write("你是猪");
            out.write("我是叶秋涵");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
