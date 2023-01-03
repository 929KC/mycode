package com.kc.system.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("bbb.txt");
        int val;
        while ((val=inputStream.read())!=-1) {
            System.out.print(val+" ");
        }
        if (inputStream!=null) {
            inputStream.close();
        }
    }
}
