package com.kc.system.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //数组追加
        Writer writer = new FileWriter("bbb.txt",true);
        writer.write("124");
        writer.write(new char []{'a','b','c','d'},0,2);
        writer.write(new char []{'e','f','g','h'});
        writer.write(new String("zxcvb"),0,3);
        writer.flush();
        writer.write("1244434");
        if (writer!=null) {
            writer.close();
        }
    }
}
