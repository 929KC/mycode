package com.bit.java.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 20:49
 */

public class ObjectInputStreamText2 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("students"));
        Object o = ois.readObject();
        System.out.println(o.toString());
        ois.close();

    }
}
