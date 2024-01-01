package com.kc.bot.config;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatBotTask implements  Runnable{
    private boolean silenced;
    private String groupName;
    private String openaiKey;
    private String cookie;
    private String groupId;

    
    @Override
    public void run() {


    }
}
