import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 929KC
 * @date 2022/12/18 20:54
 * @description:
 */
public class TcpEchoClient {
    private Socket socket;

    public TcpEchoClient(String address, int potr) throws IOException {
        this.socket = new Socket(address, potr);
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                System.out.print(">");
                String request = scanner.next();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println(request);
                printStream.flush();
                Scanner sc = new Scanner(inputStream);
                String response = sc.next();
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpServer = new TcpEchoClient("127.0.0.1",9090);
        tcpServer.start();
    }
}
