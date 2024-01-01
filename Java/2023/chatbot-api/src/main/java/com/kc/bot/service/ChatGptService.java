package com.kc.bot.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChatGptService {
    String askChatGPT(String openaiKey,String question) throws JsonProcessingException;
}
