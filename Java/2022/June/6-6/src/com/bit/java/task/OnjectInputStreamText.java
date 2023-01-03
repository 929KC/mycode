package com.bit.java.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 21:22
 */

public class OnjectInputStreamText {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("students2"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();

    }
}
