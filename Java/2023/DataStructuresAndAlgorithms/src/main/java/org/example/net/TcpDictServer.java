package org.example.net;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpEchoServer{
    private final HashMap<String, String> dict = new HashMap<>();
    public TcpDictServer(int port) throws IOException {
        super(port);
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
    }

    @Override
    public String process(String data) {
        return dict.getOrDefault(data, "词库为找到该单词！");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9092);
        server.start();
    }
}
