package com.bit.java.io;

import java.io.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 18:47
 */

public class CopyFile {
    public static void main(String[] args) {
        File src = new File("E:\\工具");
        File desc = new File("D:\\");
        copyDir(src, desc);
    }

    private static void copyDir(File src, File desc) {
        if (src.isFile()) {
            FileInputStream in=null;
            FileOutputStream out=null;
            try {
                in=new FileInputStream(src);
                String path=(desc.getAbsolutePath().endsWith("\\") ? desc.getAbsolutePath() : desc.getAbsolutePath() + "\\")+src.getAbsolutePath().substring(3);
                out=new FileOutputStream(path);
                byte []bytes=new byte[1024*1014];
                int readCount=0;
                while((readCount=in.read(bytes))!=-1){
                    out.write(bytes, 0, readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        File[] files = src.listFiles();
        for (File file : files) {
           if(file.isDirectory()) {
               // String srcDir=src.getAbsolutePath().substring(3);
               //System.out.println(srcDir);
               String srcDir = file.getAbsolutePath();
               String descDir = (desc.getAbsolutePath().endsWith("\\") ? desc.getAbsolutePath() : desc.getAbsolutePath() + "\\")+srcDir.substring(3);
               System.out.println(descDir);
               File newFile = new File(descDir);
               if (!newFile.exists()) {
                   newFile.mkdirs();
               }
           }
            copyDir(file, desc);
        }
    }
}
