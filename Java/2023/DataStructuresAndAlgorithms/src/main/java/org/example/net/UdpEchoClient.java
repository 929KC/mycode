package org.example.net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    /**
     */
    private DatagramSocket clientSocket;
    /**
     * 服务器IP地址
     */
    private String serverIp;
    /**
     * 服务器端口号
     */
    private int serverPort;
    public UdpEchoClient(String ip, int port) throws SocketException {
        //客户端可以自己指定端口号，也可以让系统自动分配，但是自己指定的端口号可能已经被使用了，所以系统分配端口号更好
        this.clientSocket = new DatagramSocket();
        this.serverIp = ip;
        this.serverPort = port;
    }

    /**
     * 启动客户端
     * @throws IOException
     */
    public void start() throws IOException {
        //1. 获取用户输入的数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入需要发送的数据->");
            String request = sc.next();
            //2. 根据用户输入的数据，将数据打包，待发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            // 3.发送数据
            clientSocket.send(requestPacket);
            // 4.接收请求
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            clientSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");
            System.out.printf("我的请求: %s, 它的回应: %s\n", request, response);
        }
    }
    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
