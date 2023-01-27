package com.kc.jop;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJop {
    @Scheduled(cron = "0/5 * * * * ?")
    public void testJop() {
        System.out.println("定时任务执行了");
    }
}
