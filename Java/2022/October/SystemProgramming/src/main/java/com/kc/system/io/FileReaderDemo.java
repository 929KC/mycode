package com.kc.system.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("bbb.txt");
//        int read = 0;
//        while((read=reader.read())!=-1) {
//            System.out.print((char)read+" ");
//        }
        char [] arr = new char[3];
        int read = 0;
        while ((read=reader.read(arr))!=-1) {
            System.out.print(Arrays.toString(arr));
        }
        reader.close();
    }
}
