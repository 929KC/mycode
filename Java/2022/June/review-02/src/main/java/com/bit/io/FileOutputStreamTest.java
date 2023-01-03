package com.bit.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:31
 */

public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream f=null;
        f=new FileOutputStream("D://io.txt",true);
        byte[] buf=new byte[]{97,98,99,100};
        f.write(buf);
        f.flush();
    }
}
