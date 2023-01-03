package com.kc.system.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        File  file = new File("./");
        System.out.println(file.createNewFile());
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
