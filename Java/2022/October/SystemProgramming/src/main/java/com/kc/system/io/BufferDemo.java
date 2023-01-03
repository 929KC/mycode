package com.kc.system.io;


import java.io.*;

/**
 * 复制文件夹下的文件
 *1.首先将文件读入内存
 * 2.将文件写到目标路径
 * 硬盘--->内存---->硬盘
 */
public class BufferDemo {
    public static void main(String[] args) {

     try(
          //这里面只能放置资源对象，用完会自动关闭：自动调用资源对象的close方法关闭资源
          //1.创建一个字节p输入流管道与图片接通
          InputStream inputStream = new FileInputStream("D:/picture/1.jpg");
          // 2.把原始的字节输入流包装成高级的缓冲字节输入流
          InputStream in = new BufferedInputStream(inputStream);
          // 3、创建一个字节输出流管道与目标文件接通
          OutputStream outputStream = new FileOutputStream("D:/picture/3.jpg");
          // 4.把字节输出流管道包装成高级的缓冲字节输出流管道
          OutputStream out = new BufferedOutputStream(outputStream);
     ){
        byte [] buffer = new byte[4];
        int size = 0;
        while ((size=in.read(buffer))!=-1) {
            System.out.println(size);
            out.write(buffer,0,size);
        }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
    }
}
