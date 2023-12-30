package com.kc.bot.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChatGptService {
    String askChatGPT(String question) throws JsonProcessingException;
}
