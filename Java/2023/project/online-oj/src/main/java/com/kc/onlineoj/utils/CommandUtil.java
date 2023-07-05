package com.kc.onlineoj.utils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class CommandUtil {
    /**
     * @param cmd
     * @param stdoutFile
     * @param stderrFile
     * @return
     */
    public static int run(String cmd, String stdoutFile, String stderrFile) {
        try {
            Runtime runtime = Runtime.getRuntime();
            //创建进程
            Process exec = runtime.exec(cmd);
            if (stdoutFile != null) {
                InputStream inputStream = exec.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(stdoutFile);
                while (true) {
                    int ch = inputStream.read();
                    if (ch == -1) {
                        break;
                    }
                    fileOutputStream.write(ch);
                }
                inputStream.close();
                fileOutputStream.close();
            }
            if (stderrFile != null) {
                InputStream errorStream = exec.getErrorStream();
                FileOutputStream fileOutputStream1 = new FileOutputStream(stdoutFile);
                while (true) {
                    int ch = errorStream.read();
                    if (ch == -1) {
                        break;
                    }
                    fileOutputStream1.write(ch);
                }
                errorStream.close();
                fileOutputStream1.close();
            }
            int statusCode = exec.waitFor();
            return statusCode;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
