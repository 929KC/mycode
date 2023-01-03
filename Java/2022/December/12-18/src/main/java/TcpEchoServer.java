
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 929KC
 * @date 2022/12/18 20:54
 * @description:
 */
public class TcpEchoServer {
    private ServerSocket serverSocket;

    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executor = Executors.newCachedThreadPool();
        while (true) {
            Socket clientServer = serverSocket.accept();
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public void  processConnection(Socket clientServer) throws IOException {
        System.out.printf("[%s:%d] 客户端上线!\n", clientServer.getInetAddress().toString(), clientServer.getPort());
        try (InputStream inputStream = clientServer.getInputStream();
             OutputStream outputStream = clientServer.getOutputStream();) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线!\n", clientServer.getInetAddress().toString(),
                            clientServer.getPort());
                    break;
                }
                String request = scanner.next();
                String response = process(request);
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientServer.getInetAddress().toString(),
                        clientServer.getPort(), request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientServer.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpServer = new TcpEchoServer(9090);
        tcpServer.start();
    }

}
