package task;

import java.io.*;

public class StreamWriteTest {
    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream("E:\\tet.txt");
            OutputStreamWriter sw = new OutputStreamWriter(out,"utf-8");
            sw.write("我爱");
            System.out.println("写入成功");
            sw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
