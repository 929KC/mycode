package com.bit.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 13:45
 */

public class DataInputStreamText  {
    public static void main(String[] args) throws Exception{
        DataInputStream in=new DataInputStream(new FileInputStream("data"));
        byte b = in.readByte();
        short i = in.readShort();
        int i1 = in.readInt();
        long l = in.readLong();
        float v = in.readFloat();
        double v1 = in.readDouble();
        char c = in.readChar();
        System.out.println(b);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(l);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(c);


    }
}
