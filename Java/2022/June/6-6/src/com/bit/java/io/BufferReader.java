package com.bit.java.io;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 12:52
 */

import java.io.*;

/**
 * 带有缓冲区的字符输入流
 * 使用这个流的时候不需要自定义char数组,或者说不需要自定义byte数组,自带缓冲
 */
public class BufferReader {

    public static void main(String[] args) {
        FileReader reader =null;
        BufferedReader br =null;
        try {
            //当一个流的构造方法需要一个流的时候,这个被传过来的流叫做节点流
            //外部负责包装的这个流,叫做：包装流,也被叫做:处理流
         reader=new FileReader("E:\\tet.txt");
        br = new BufferedReader(reader);
         String s=null;
         //结束标志遇到null
         while ((s=br.readLine()) != null){
             System.out.println(s);
         }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
