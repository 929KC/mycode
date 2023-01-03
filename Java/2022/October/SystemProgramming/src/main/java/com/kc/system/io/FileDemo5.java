package com.kc.system.io;

import java.io.BufferedReader;
import java.io.File;

public class FileDemo5 {
    public static void main(String[] args) {
        File file = new File("D:/Demo");
        System.out.println(file.delete());
        File file3 = new File("D:/test/C/C++");
        System.out.println(file3.delete());
    }
}
