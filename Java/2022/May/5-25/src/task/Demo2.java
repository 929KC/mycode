package task;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-25 10:45
 */

public class Demo2 {
    public static void main(String[] args) throws Exception {
        FileReader file = new FileReader("E:\\tet.txt");
        BufferedReader reader = new BufferedReader(file);
        String s=" ";
                while((s=reader.readLine())!=null){
                    System.out.println(s);
                }
                reader.close();
    }
}
