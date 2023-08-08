package org.example.net.http.version1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {
    //HTTPs是基于TCP实现的,所以该HTTP依旧按照TCP的基本格式开发
    private ServerSocket serverSocket;

    /**
     *
     * @param port 端口
     * @throws IOException
     */
    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public  void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService exec = Executors.newCachedThreadPool();
        while (true) {
            //1.获取连接
            Socket clinetSocket = serverSocket.accept();
            //处理请求,以短连接方式
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    process(clinetSocket);
                }
            });

        }
    }

    /**
     * 解析并处理请求
     * @param clinetSocket
     */
    private void process(Socket clinetSocket) {
        //由于HTTP是文本协议,所以用字符流处理
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clinetSocket.getOutputStream()))
        ){
            //下面操作按照HTTP协议来解析
            //1.读取请求并解析
            String firstLine = reader.readLine();
            //HTTP首行是的部分是用空格分隔的
            String[] firstLineTokens = firstLine.split(" ");
            //得到HTTP请求的类型
            String method = firstLineTokens[0];
            //得到url
            String url = firstLineTokens[1];
            //得到HTTP版本
            String version = firstLineTokens[2];
            //解析header,按行读取,然后按冒号分隔键值对
            Map<String,String> headers = new HashMap<String,String>();
            String line = "";
            //注意:readLine读取的一行内容,是会自动去掉换行,对于空行来说,去掉换行,就变成了空字符串
            while ((line = reader.readLine())!=null&&!line.equals("")) {
                String [] headerTokens = line.split(": ");
                headers.put(headerTokens[0], headerTokens[1]);
            }
            //解析body,暂时不考虑
            //打印内容,看是否正确
            System.out.printf("%s %s %s\n",method,url,version);
            for (Map.Entry<String,String> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            //处理请求
            String body = "";
            if (url.equals("/200")) {
                writer.write(version+" 200 ok\n");
                body = "<h1>Hello World</h1>";
            }else if (url.equals("/404")) {
                writer.write(version+" 404 ok\n");
                body = "<h1>NOT FOUND</h1>";
            }else if (url.equals("/302")) {
                writer.write(version+" 302 Found\n");
                writer.write("Location: http://www.bilibili.com\n");
                body = "";
            }else {
                writer.write(version+" 200 ok\n");
                body = "<h1>default</h1>";
            }
            //把响应写会给客户端
            writer.write("Content-type: text/html\n");
            writer.write("Content-Length: "+body.getBytes().length+"\n");
            writer.write("\n");
            writer.write(body);
            writer.flush();
            clinetSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer(9090);
        server.start();
    }
}
