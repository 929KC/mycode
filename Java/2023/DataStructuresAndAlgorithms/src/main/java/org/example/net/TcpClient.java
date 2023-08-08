package org.example.net;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    //服务端IP或域名
    private static final String SERVER_HOST = "localhost";
    //服务端Socket进程的端口号
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        // 3.创建一个客户端流套接字Socket，并与对应IP的主机上，对应端口的进程建立连接
        Socket client = new Socket(SERVER_HOST, SERVER_PORT);
        // 4.发送TCP数据，是通过socket中的输出流进行发送
        OutputStream os = client.getOutputStream();
        // 为了方便输出字符串作为发送的内容，可以将以上字节流包装为字符流
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        // 4-1.发送数据：
        pw.println("hello world!");
        // 4-2.有缓冲区的IO操作，真正传输数据，需要刷新缓冲区
        pw.flush();
        // 7.双方关闭连接：客户端关闭socket连接
        client.close();
    }
}