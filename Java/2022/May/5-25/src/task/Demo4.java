package task;

import java.io.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-25 11:01
 */

public class Demo4 {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\tet.txt");
        FileInputStream in = new FileInputStream(file);
        DataInputStream dout = new  DataInputStream(in);
        int n=dout.readInt();
        double d=dout.readDouble();
       /// String str=dout.readUTF();
        System.out.println(n);
        System.out.println(d);
    //    System.out.println(str);
        dout.close();
        System.out.println("读出成功");
    }
}
