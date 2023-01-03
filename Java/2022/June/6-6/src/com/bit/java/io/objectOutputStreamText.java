package com.bit.java.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 20:35
 */

public class objectOutputStreamText {


    public static void main(String[] args) throws Exception {
        //创建java对象
        Student s=new Student("黄茂荣","12");
        //序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("students"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

    }


}
