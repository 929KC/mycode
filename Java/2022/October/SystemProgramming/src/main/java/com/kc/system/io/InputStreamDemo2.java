package com.kc.system.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("bbb.txt");
        byte[] buffer = new byte[3];
        int len; // 记录每次读取的字节数。
        while ((len = inputStream.read(buffer)) != -1) {
            // 读取多少倒出多少
            System.out.print(new String(buffer, 0 , len));
        }
        if (inputStream!=null) {
            inputStream.close();
        }
    }
}
