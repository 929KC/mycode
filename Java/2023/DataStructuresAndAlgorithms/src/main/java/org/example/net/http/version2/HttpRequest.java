package org.example.net.http.version2;

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
    private Map<String,String> headers = new HashMap<String,String>();
    private Map<String,String> parameters = new HashMap<String,String>();

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        //1.解析首行
        String firstLine = reader.readLine();
        String  [] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url中的参数
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            //获得url中?之后的字符,有字符则解析,没有就不处理
            String parameters = request.url.substring(pos + 1);
            //切分的结果,key a,value 10
            parseKV(parameters,request.parameters);
        }
        //3.解析header
        String line = "";
        while ((line = reader.readLine()) != null&&line.length()!=0) {
            String [] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0], headerTokens[1]);
        }
        //4.解析body,暂时不考虑
        return  request;

    }

    /**
     * 将url中的键值对存储到output
     * @param parameters
     * @param output
     * @throws IOException
     */
    private static void parseKV(String parameters, Map<String, String> output) throws IOException{
        //按&切分成若干组键值对
        String [] kvTokens = parameters.split("&");
        //针对上述切分结果在按照=进行切分
        for (String kvToken : kvTokens) {
            String [] result = kvToken.split("=");
            output.put(result[0],result[1]);
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

    public String getParameters(String key) {
        return parameters.get(key);
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
