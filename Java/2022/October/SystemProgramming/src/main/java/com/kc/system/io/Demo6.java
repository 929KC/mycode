package com.kc.system.io;

import java.io.UnsupportedEncodingException;

public class Demo6 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "今天天气真好";
        //指定编码
        byte[] bytes = str.getBytes("UTF-8");
        //解码 将字节转换成中文(编码前后的字符集需要一致,否则会乱码)
        String s = new String(bytes,"UTF-8");
        System.out.println(s);
    }
}
