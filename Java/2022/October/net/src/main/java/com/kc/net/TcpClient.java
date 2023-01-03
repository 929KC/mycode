package com.kc.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private Socket socket ;

    public TcpClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp, serverPort);
    }

    public void start() throws IOException {
        Scanner sc= new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();){
            while (true) {
                System.out.print("-->");
                String request = sc.next();
                //发送请求
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println(request);
                printStream.flush();
                //从服务器读取响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                System.out.println(response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpClient tcpServer = new TcpClient("127.0.0.1",9090);
        tcpServer.start();
    }

}
