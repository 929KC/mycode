package org.example.net.http.version3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责响应
 */
public class HttpResponse {
    /**
     * HTTP版本
     */
    private String version = "HTTP/1.1";
    /**
     * 状态码
     */
    private int status;
    /**
     * 状态码的描述信息
     */
    private String message;
    /**
     * header
     */
    private Map<String, String> header = new HashMap<String, String>();
    /**
     * 响应体
     */
    private StringBuilder body = new StringBuilder();
    /**
     * 用于给客户端写数据
     */
    private OutputStream outputStream;

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;


        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String key,String value) {
        header.put(key,value);
    }

    public void writeBody(String content) {
        body.append(content);
    }

    public void flush() throws IOException {
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        write.write(version+" "+status+" "+message+"\n");
        header.put("Content-Length",body.toString().getBytes().length+"");
        for(Map.Entry<String,String> entry:header.entrySet()) {
            write.write(entry.getKey()+":"+entry.getValue()+"\n");
        }
        write.write("\n");
        write.write(body.toString());
        write.flush();
    }

}
