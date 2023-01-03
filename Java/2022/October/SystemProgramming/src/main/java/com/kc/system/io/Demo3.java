package com.kc.system.io;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("./io/demo/text");
       // file.mkdir();
        file.mkdirs();
    }
}
