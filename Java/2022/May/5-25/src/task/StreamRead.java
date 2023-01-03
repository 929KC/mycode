package task;

import java.io.*;

public class StreamRead {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("E:\\tet.txt");
            InputStreamReader sread = new InputStreamReader(in,"utf-8");
            BufferedReader bufread = new BufferedReader(sread);
            String s = bufread.readLine();
            System.out.println(s);
            FileOutputStream out = new FileOutputStream("E:\\tet.txt",true);
            OutputStreamWriter sw = new OutputStreamWriter(out,"utf-8");
            sw.write(s);
            System.out.println("写入成功");
            bufread.close();
            sw.flush();
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
