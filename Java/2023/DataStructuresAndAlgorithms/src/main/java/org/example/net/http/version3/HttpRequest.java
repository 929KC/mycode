package org.example.net.http.version3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 表示一个HTTP请求,并负责解析
 */
public class HttpRequest {
    private String method;
    private String version;
    private String url;
    private String body;
    private Map<String, String> cookies = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<String, String>();
    private Map<String, String> parameters = new HashMap<String, String>();

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        //1.解析首行
        String firstLine = reader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url中的参数
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            //获得url中?之后的字符,有字符则解析,没有就不处理
            String parameters = request.url.substring(pos + 1);
            //切分的结果,key a,value 10
            parseKV(parameters, request.parameters);
        }
        //3.解析header
        String line = "";
        while ((line = reader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0], headerTokens[1]);
        }
        //4.解析cooike
        String cookie = request.headers.get("Cookie");
        if (cookie != null) {
            paseCookie(cookie, request.cookies);
        }
        //5.解析body
        if ("POST".equalsIgnoreCase(request.method) || "PUT".equalsIgnoreCase(request.method)) {
            // 需要把 body 读取出来.
            // 需要先知道 body 的长度. Content-Length 就是干这个的.
            // 此处的长度单位是 "字节"
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            // 注意体会此处的含义~~
            // 例如 contentLength 为 100 , body 中有 100 个字节.
            // 下面创建的缓冲区长度是 100 个 char (相当于是 200 个字节)
            // 缓冲区不怕长. 就怕不够用. 这样创建的缓冲区才能保证长度管够~~
            char[] buffer = new char[contentLength];
            int len = reader.read(buffer);
            request.body = new String(buffer, 0, len);
            // body 中的格式形如: username=tanglaoshi&password=123
            parseKV(request.body, request.parameters);
        }
        return request;

    }

    private static void paseCookie(String cookie, Map<String, String> cookies) {
        // 1. 按照 分号空格 拆分成多个键值对
        //[0]b-user-id=120
        //[1]sessionId=120
        String[] kvTokens = cookie.split("; ");
        // 2. 按照 = 拆分每个键和值
        for (String kv : kvTokens) {
            String[] result = kv.split("=");
            System.out.println(result[0]);
            System.out.println(result[1]);
            cookies.put(result[0], result[1]);
        }
    }

    /**
     * 将url中的键值对存储到output
     *
     * @param parameters
     * @param output
     * @throws IOException
     */
    private static void parseKV(String parameters, Map<String, String> output) throws IOException {
        //按&切分成若干组键值对
        String[] kvTokens = parameters.split("&");
        //b-user-id=120;sessionId=120
        //针对上述切分结果在按照=进行切分
        for (String kvToken : kvTokens) {
            String[] result = kvToken.split("=");
            output.put(result[0], result[1]);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getVersion() {
        return version;
    }

    public String getUrl() {
        return url;
    }

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getBody() {
        return body;
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", version='" + version + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
