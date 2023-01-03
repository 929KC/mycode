package com.kc.net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Udpechoclient {
    private DatagramSocket socket ;
    private String serverIp;
    private  int serverPort;
    private Scanner sc = new Scanner(System.in);
    public Udpechoclient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort =serverPort;
    }

    public  void start() throws IOException {
        while (true) {
            System.out.print("-->");
            String request = sc.nextLine();
            //构造UDP请求,发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(
                    request.getBytes(),request.getBytes().length,
                   InetAddress.getByName(this.serverIp),this.serverPort
            );
            socket.send(requestPacket);
            // 3. 从服务器读取 UDP 响应数据. 并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[2048], 2048);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            // 4. 把服务器的响应显示到控制台上.
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        Udpechoclient client = new Udpechoclient("127.0.0.1",9090);
        client.start();
    }
}
