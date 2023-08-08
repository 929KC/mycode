package org.example.net.http.version3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {
    private ServerSocket serverSocket;
    private HashMap<String, User> sessions = new HashMap<>();

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
        // 处理核心逻辑
        try {
            // 1. 读取请求并解析
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response =
                    HttpResponse.build(clientSocket.getOutputStream());
            // 2. 根据请求计算响应
            // 此处按照不同的 HTTP 方法, 拆分成多个不同的逻辑
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                // 其他方法, 返回一个 405 这样的状态码
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            // 3. 把响应写回到客户端
            response.flush();
            // 4. 关闭 socket
            clientSocket.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void doPost(HttpRequest request, HttpResponse response) {
        // 2. 实现 /login 的处理
        if (request.getUrl().startsWith("/login")) {
            // 读取用户提交的用户名和密码
            String userName = request.getParameters("username");
            String password = request.getParameters("password");
            System.out.println("userName: " + userName);
            System.out.println("password: " + password);
            if ("zhangsan".equals(userName) && "123".equals(password)) {
                // 登陆成功
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.userName = "zhangsan";
                user.age = 20;
                user.school = "陕科大";
                sessions.put(sessionId, user);
                response.setHeader("Set-Cookie", "sessionId=" + sessionId);
                response.writeBody("<html>");
                response.writeBody("<div>欢迎您! " + userName + "</div>");
                response.writeBody("</html>");
            } else {
                // 登陆失败
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>登陆失败</div>");
                response.writeBody("</html>");
            }
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        // 1. 能够支持返回一个 html 文件.
        if (request.getUrl().startsWith("/index.html")) {
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                InputStream inputStream =
                        org.example.net.http.version2.HttpServer.class.getClassLoader().getResourceAsStream("index.html");
                BufferedReader bufferedReader = new BufferedReader(new
                        InputStreamReader(inputStream));
                // 按行读取内容, 把数据写入到 response 中
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    response.writeBody(line + "\n");
                }
                bufferedReader.close();
            } else {
                // 用户已经登陆, 无需再登陆了.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer(9090);
        server.start();
    }
}
