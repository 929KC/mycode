package com.kc.onlineoj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class OnlineOjApplicationTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        //JVM中为单0
        Runtime runtime = Runtime.getRuntime();
        //创建一个进程
        Process proces = runtime.exec("javac");
        InputStream stdoutFrom = proces.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("stdout.txt");
        while (true){
            int ch = stdoutFrom.read();
            if (ch ==-1){
                break;
            }
            fileOutputStream.write(ch);
        }
        stdoutFrom.close();
        fileOutputStream.close();
        InputStream sdterrFrom = proces.getErrorStream();
        FileOutputStream fileOutputStream2 = new FileOutputStream("stderror.txt");
        while (true){
            int ch = sdterrFrom.read();
            if (ch ==-1){
                break;
            }
            fileOutputStream2.write(ch);
        }
        sdterrFrom.close();
        fileOutputStream2.close();
        int exitCode = proces.waitFor();
        System.out.println(exitCode);
    }

}
