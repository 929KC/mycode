package com.bit.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:51
 */

public class FileWriterTest {
    public static void main(String[] args) throws Exception {
        FileWriter writer = null;
        writer = new FileWriter("D://io.txt",true);
        char[] buf = new char[]{'我','是','叶','子'};
        writer.write(buf);
        writer.flush();
    }
}
