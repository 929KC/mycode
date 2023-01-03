package com.kc.system.io;

import java.io.*;

public class BufferCopyDemo {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("D:/picture/demo.txt");
            BufferedReader br = new BufferedReader(reader);
            Writer writer = new FileWriter("D:/picture/demo2.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            ) {
            int len = 0;
            char [] buffer = new char[4];
            while ((len = br.read(buffer))!=-1) {
                bw.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
