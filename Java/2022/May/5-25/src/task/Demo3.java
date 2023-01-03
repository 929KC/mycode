package task;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-25 10:55
 */

public class Demo3 {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\tet.txt");
        FileOutputStream out = new FileOutputStream(file);
        DataOutputStream dout = new DataOutputStream(out);
        dout.write(123);
        dout.writeDouble(12.345);
      //  dout.writeUTF("我是");
        dout.flush();
        dout.close();
        System.out.println("写入成功");
    }
}
