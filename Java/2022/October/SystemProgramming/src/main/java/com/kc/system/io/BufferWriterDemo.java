package com.kc.system.io;


import java.io.*;
public class BufferWriterDemo {
    public static void main(String[] args) {
        try(Writer write = new FileWriter("bbb.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(write);){
            bufferedWriter.write(97);
            bufferedWriter.write(new  char[]{'b','c','d','e','f'});
            bufferedWriter.newLine();
            bufferedWriter.write(new String("efasdfg"));
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
