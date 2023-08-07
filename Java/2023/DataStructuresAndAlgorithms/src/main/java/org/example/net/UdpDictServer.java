package org.example.net;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer{
    //最简单的翻译处理服务器
    private final HashMap<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        //词库
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("bird", "小鸟");
    }

    @Override
    public String process(String data) {
        return dict.getOrDefault(data, "词库没有该单词!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
