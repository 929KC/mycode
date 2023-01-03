package com.bit.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *idea中默认的根路径即工程
 */

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 09:03
 */

public class FileInputStreamText01 {
    public static void main(String[] args)  {
        FileInputStream f=null;
        try {
            f=new FileInputStream("E:\\tet.txt");
//            while(true){
//                int read=f.read();
//             if(read==-1){
//                 break;
//             }
//                System.out.print((char)read);
//            }
            int read=0;
            while((read=f.read())!=-1){
                System.out.print(read+" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
          if(f!=null){
              try {
                  f.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }

    }
}
