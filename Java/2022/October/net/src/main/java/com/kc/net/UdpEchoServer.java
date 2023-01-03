package com.kc.net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 回显服务器
 */
public class UdpEchoServer {
    //UDP Socket ,用于发送和接收UDP数据报
    private DatagramSocket socket;
    //给服务器分配端口号
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            //1.服务器读取解析请求 开辟的内存空间是为了存储响应的数据
            DatagramPacket requestPacket = new DatagramPacket(new byte[2048],2048);
            //接收数据报
            socket.receive(requestPacket);
            //将请求转换成字符串
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength());
            //2.根据请求计算响应
            String response = process(request);
            //3.将响应发送会客户端
            DatagramPacket responsePacket = new
                    DatagramPacket(response.getBytes(),
                    response.getBytes().length,
                    requestPacket.getSocketAddress());//getSocketAddress()封装了客户端的ip以及端口号
            socket.send(responsePacket);
            //打印日志
            System.out.printf("[%s:%d] request: %s response: %s\n",
                    requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    /**
     * 处理请求
     * @param request
     * @return
     * @throws SocketException
     */
    public String process(String request) throws SocketException {
        return  request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
