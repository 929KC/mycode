package com.bit.io;

import java.io.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 08:19
 */

public class BufferWriterTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fo=new FileOutputStream("D://io4.txt");
        OutputStreamWriter osw=new OutputStreamWriter(fo);
        BufferedWriter bw=new BufferedWriter(osw);
        bw.write("Hello World");
        bw.flush();
        bw.close();
    }
}
