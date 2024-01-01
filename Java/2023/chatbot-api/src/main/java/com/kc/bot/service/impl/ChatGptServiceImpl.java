package com.kc.bot.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.bot.model.AIAnswer;
import com.kc.bot.model.Choices;
import com.kc.bot.service.ChatGptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ChatGptServiceImpl implements ChatGptService {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public String askChatGPT(String openaiKey, String question) throws JsonProcessingException {
        String url = "https://api.openai.com/v1/chat/completions";

        // 使用字符串格式化将 question 参数插入到 JSON 字符串中
        String jsonStr = String.format(
                "{\"model\": \"gpt-3.5-turbo\",\"messages\": [{\"role\": \"user\",\"content\": \"%s\"}],\"temperature\": 0.7}",
                question.replace("\"", "\\\"") // 确保 question 中的双引号被正确转义
        );

        HttpResponse response = HttpRequest.post(url)
                .setHttpProxy("127.0.0.1", 7890)
                .header("Content-Type", "application/json")
                .header("Authorization", openaiKey)
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .body(jsonStr)
                .execute();

        if (response.isOk()) {
            AIAnswer answer = objectMapper.readValue(response.body(), AIAnswer.class);
            List<Choices> choices = answer.getChoices();
            StringBuilder sb = new StringBuilder();
            for (Choices choice : choices) {
                sb.append(choice.getMessage().getContent());
            }
            return sb.toString();
        } else {
            throw new RuntimeException("调用出错" + response.getStatus());
        }
    }
}
