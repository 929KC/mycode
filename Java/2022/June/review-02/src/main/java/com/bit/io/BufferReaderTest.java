package com.bit.io;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 08:15
 */

public class BufferReaderTest {
    public static void main(String[] args) throws Exception {
        FileReader fi=new FileReader("D://io.txt");
        BufferedReader br=new BufferedReader(fi);
        String s=null;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }
        br.close();
    }
}
