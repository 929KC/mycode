
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 929KC
 * @date 2022/12/18 17:28
 * @description:
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverAddress;
    private int serverPort;

    public UdpEchoClient(String serverAddress, int serverPort) throws SocketException {
        this.socket = new DatagramSocket();
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String request = sc.next();
            //构造请求数据报
            DatagramPacket packet = new DatagramPacket(request.getBytes(), 0, request.getBytes().length, InetAddress.getByName("127.0.0.1"), this.serverPort);
            socket.send(packet);
            DatagramPacket respose = new DatagramPacket(new byte[2048], 2048);
            socket.receive(respose);
            String responseData = new String(respose.getData(), 0, respose.getLength());
            System.out.println(responseData);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
        udpEchoClient.start();
    }
}
