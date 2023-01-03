package com.kc.system.io;


import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //append设置为true表示为可以在文件后追加数据,不会将第一次的数据给刷了
        OutputStream outputStream = new FileOutputStream("bbb.txt",true);
        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(99);
        byte [] buffer = new byte[]{100,101,102};
        outputStream.write(buffer);
        byte[] bytes = "1223".getBytes();
        outputStream.write(bytes,0,2);
        //为了避免频繁对硬盘操作,是先将数据放到缓冲区,然后数据在将数据磁写到文件
        outputStream.flush();//关闭前要刷新缓冲区,将剩余的数据全部写到文件
        if (outputStream!=null) {
            outputStream.close();
        }
    }
}
