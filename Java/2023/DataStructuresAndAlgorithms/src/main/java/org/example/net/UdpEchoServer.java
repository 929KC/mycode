package org.example.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    /**
     *  准备好socket实例，准备传输
     */
    private DatagramSocket serverSocket;

    /**
     *指定端口
     * @param port
     * @throws SocketException
     */
    public UdpEchoServer(int port) throws SocketException {
        this.serverSocket = new DatagramSocket(port);
    }

    /**
     * 启动服务器
     * @throws IOException
     */
    public void start() throws IOException {
        System.out.println("服务器准备就绪！");
        while (true) {
            //1. 读取客户端的请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);//参数为储存数据的数组与最大空间大小
            serverSocket.receive(requestPacket);
            //2. 解析收到的数据包，一般解析成字符串进行处理
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "UTF-8");
            //3. 处理请求
            String response = process(request);
            //4. 发送请求，因为数据的传输是依据DatagramPacket来进行传输的，所以我们需要先包装在发送
            //除此之外，我们还需要知道客户端的地址和端口号
            //接收DatagramPacket对象时。该对象里面存有客户端的地址和端口号。可以使用getSocketAddress方法获取
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,
                    requestPacket.getSocketAddress());
            serverSocket.send(responsePacket);
            //5. 输出发送日志
            System.out.printf("[%s:%d] 收到的请求: %s, 回应: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    /**
     * .处理数据，回显服务直接将原数据返回即可
     * @param data
     * @return
     */
    public String process(String data) {
        return data;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
