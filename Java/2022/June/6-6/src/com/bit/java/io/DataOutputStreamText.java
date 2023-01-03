package com.bit.java.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 13:44
 */

public class DataOutputStreamText {
    public static void main(String[] args) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data"));
        byte b=90;
        short s=9090;
        int i=9090909;
        long l=979;
        float f=234;
        double d=68789;
        char c='a';
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeChar(c);
        dos.flush();
        dos.close();
    }
}
