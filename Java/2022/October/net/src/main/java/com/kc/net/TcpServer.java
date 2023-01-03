package com.kc.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    //只有一份,随着进程的销毁而回收
    private ServerSocket listenSocket;

    public TcpServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }
    public  void start() throws IOException {
        System.out.println("服务器启动了");
        while (true) {
            //Socket是一个文件,clientSocket会随着客户端数量的增加而增加 ,所以需要关闭。
            //accept没有接收到请求的时候会阻塞
            Socket clientSocket = listenSocket.accept();
            Thread t =new Thread(()->{//当有多个客户端发送请求时
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
    public void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d]客户端上线了\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream();){
            while (true) {
                Scanner sc = new Scanner(inputStream);
                //当在缓冲区内扫描到字符时，会返回true， 否则会发生阻塞，等待数据输入。注意 hasNext是不会返回false的
                if (!sc.hasNext()) {
                    System.out.printf("[%S %d] 客户端下线了!\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    break;
                }
                //读取请求
                String request = sc.next();
                //根据请求计算响应
                String response = process(request);
                //将响应写给客户端
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                //刷新缓冲区确保数据发送出去
                printWriter.flush();
                System.out.printf("[%s %d] request: %s response: %s\n",clientSocket.getInetAddress().toString(),clientSocket.getPort(),request,response
                );
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            clientSocket.close();
        }

    }
    public String process(String request) throws IOException {
        return  request;
    }

    public static void main(String[] args) throws IOException {
        TcpServer tcpServer = new TcpServer(9090);
        tcpServer.start();
    }
}
