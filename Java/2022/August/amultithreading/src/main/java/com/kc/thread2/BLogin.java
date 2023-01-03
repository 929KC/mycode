package com.kc.thread2;

public class BLogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("bb","bb");
    }
}
