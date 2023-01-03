package com.kc.system.io;

import java.io.File;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        File file = new File ("aaa.txt");
        file.createNewFile();
        File file2 = new File ("bbb.txt");
        file.renameTo (file2);
    }
}
