import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * @author 929KC
 * @date 2022/12/18 17:16
 * @description:
 */
public class UdpEchoServer {
    private DatagramSocket socket;

    public UdpEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    private void start() throws IOException {
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[2048], 2048);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String respose = process(request);
            DatagramPacket responsePacket = new DatagramPacket(respose.getBytes(),0,respose.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req:; %s resp: %s\n",requestPacket.getAddress().toString(),requestPacket.getPort(),
                    request,respose);
        }

    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
