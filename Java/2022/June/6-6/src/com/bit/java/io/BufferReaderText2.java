package com.bit.java.io;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 13:09
 */

import java.io.*;

/**
 * 转换流
 */
public class BufferReaderText2 {
    public static void main(String[] args) {
        FileInputStream in=null;
        InputStreamReader reader=null;
        try {
//            in=new FileInputStream("E:\\tet.txt");
//            //通过转换流将字节流转换成字符流
//            //in为节点流,外部则为包装流
//            reader=new InputStreamReader(in);
//            BufferedReader br=new  BufferedReader(reader);
//            String s=null;
            String s=null;
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\tet.txt")));
            while ((s=br.readLine()) != null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
