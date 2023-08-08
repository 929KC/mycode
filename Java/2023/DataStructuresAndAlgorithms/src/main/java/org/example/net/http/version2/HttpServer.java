package org.example.net.http.version2;

import org.example.net.http.version3.HttpRequest;
import org.example.net.http.version3.HttpResponse;
import org.example.net.http.version3.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {
    private ServerSocket serverSocket;
    /**
     * sessions 中就包含很多会话. (每个键值对就是一个会话)
     */


    public HttpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService exec = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            exec.execute(() -> process(clientSocket));
        }
    }

    /**
     * 处理请求
     *
     * @param clientSocket
     */
    private void process(Socket clientSocket) {
        try {
            //1.读取并解析请求
            org.example.net.http.version3.HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println("request:" + request);
            org.example.net.http.version3.HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            //2.根据请求计算响应
            if (request.getUrl().startsWith("/200")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>Hello World</h1>");
            } else if (request.getUrl().startsWith("/add")) {
                String atr = request.getParameters("a");
                String btr = request.getParameters("a");
                int a = Integer.parseInt(atr);
                int b = Integer.parseInt(btr);
                int result = a + b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>result = " + result + "</h1>");
            } else if (request.getUrl().startsWith("/cookieUser")) {
                response.setStatus(200);
                response.setMessage("OK");
                // HTTP 的 header 中允许有多个 Set-Cookie 字段. 但是
                // 此处 response 中使用 HashMap 来表示 header 的. 此时相同的 key 就覆盖
                response.setHeader("Set-Cookie", "user=zhangsan");
                response.writeBody("<h1>set cookieUser</h1>");
            } else if (request.getUrl().startsWith("/cookieTime")) {
                response.setStatus(200);
                response.setMessage("OK");
                // HTTP 的 header 中允许有多个 Set-Cookie 字段. 但是
                // 此处 response 中使用 HashMap 来表示 header 的. 此时相同的 key 就覆盖
                response.setHeader("Set-Cookie", "time=" + (System.currentTimeMillis() / 1000));
                response.writeBody("<h1>set cookieTime</h1>");
            } else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>default</h1>");
            }
            // 3. 把响应写回到客户端
            response.flush();
            // 4. 关闭 socket
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer(9090);
        server.start();
    }
}
