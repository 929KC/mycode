package org.example.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    /**
     * 创建Socket对象
     */
    private Socket socket;

    /**
     *
     * @param serverIP  服务端ip
     * @param serverPort 服务端口
     * @throws IOException
     */
    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        socket = new Socket(serverIP, serverPort);
    }

    /**
     * 启动客户端
     */
    public void start() {
        System.out.println("客户端启动成功！");
        //用户输入数据
        Scanner input = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    //请输入数据
                    System.out.print("请输入需要传输的数据!->");
                    String request = input.next();
                    //发送数据
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    //刷新缓冲区
                    printWriter.flush();
                    //接收回应
                    Scanner receiverScanner = new Scanner(inputStream);
                    String response = receiverScanner.next();
                    //输出数据
                    System.out.printf("我的请求：%s 它的回应：%s\n", request, response);
                }
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9092);
        client.start();
    }
}
