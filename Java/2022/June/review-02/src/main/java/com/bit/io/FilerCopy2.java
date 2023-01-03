package com.bit.io;


import java.io.FileReader;
import java.io.FileWriter;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 07:55
 */

public class FilerCopy2 {
    public static void main(String[] args) throws Exception {
        FileReader fr=null;
        FileWriter fw=null;
        fr=new FileReader("D://io.txt");
        fw=new FileWriter("D://io3.txt",true);
        int count=0;
        char [] chars=new char[1024*1024];
        while ((count= fr.read(chars))!=-1){
            fw.write(chars,0,count);
        }
        fw.flush();
    }
}
