package com.kc.thread2;

public class ALogin extends Thread{
    @Override
    public void run() {
      LoginServlet.doPost("a","aa");
    }
}
