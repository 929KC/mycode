package com.bit.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-06 14:18
 */

public class LogUtils {

   public static void Log(String message) {

       try {
           PrintStream  ps = new PrintStream(new FileOutputStream("log.txt",true));
           //修改输方向,将输出的方向啊修改到log.txt中
           System.setOut(ps);
           Date date=new Date();
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
           String mes=sdf.format(date);
           System.out.println(mes+":"+message);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

   }

}
