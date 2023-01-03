package com.bit.java.task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 21:23
 */

public class ObjectOutputStreamText {
    public static void main(String[] args) throws Exception {
        Student s=new Student("黄茂荣","12");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("students2"));
        oos.writeObject(s);
        oos.flush();
        oos.close();
    }
}
