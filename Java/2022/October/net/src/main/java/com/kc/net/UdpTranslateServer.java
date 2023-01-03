package com.kc.net;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpTranslateServer extends UdpEchoServer{
    private Map<String,String> dict = new HashMap<>();
    public UdpTranslateServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("pig","猪猪侠");

    }

    @Override
    public String process(String request) throws SocketException {
        return dict.getOrDefault(request,"词典中未找到");
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateServer udpEchoClient = new UdpTranslateServer(9090);
        udpEchoClient.start();
    }
}
