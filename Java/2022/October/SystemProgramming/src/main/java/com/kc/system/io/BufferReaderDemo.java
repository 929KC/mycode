package com.kc.system.io;

import java.io.*;


public class BufferReaderDemo {
    public static void main(String[] args) {
       try(Reader reader = new FileReader("bbb.txt");
           BufferedReader bufferedReader = new BufferedReader(reader);
       ){
        char [] buffer = new char[4];
        int len = 0;
         while ((len=bufferedReader.read(buffer))!=-1) {
             System.out.println(new String(buffer,0,len));
         }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
