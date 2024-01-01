package com.kc.bot.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.bot.model.*;
import com.kc.bot.service.KnowledgeGalaxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class KnowledgeGalaxyServiceImpl implements KnowledgeGalaxyService {
    @Resource
    private ObjectMapper objectMapper;

    /**
     * @param groupId
     * @param cookie
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws JsonProcessingException {
        String url = "https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=unanswered_questions&count=20";
        HttpResponse response = HttpRequest.get(url)
                .header("cookie", cookie)
                .header("Content-Type", "application/json;charset=utf8").execute();
        System.out.println(response);
        if (response.isOk()) {
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = objectMapper.readValue(response.body(), UnAnsweredQuestionsAggregates.class);
            return unAnsweredQuestionsAggregates;
        } else {
            throw new RuntimeException("请求失败");
        }
    }

    /**
     * @param groupId
     * @param cookie
     * @param topicId
     * @param text
     * @param silenced
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws JsonProcessingException {
        String url = "https://api.zsxq.com/v2/topics/" +topicId + "/answer";
        AnswerReq answerReq = new AnswerReq(new ReqData(text, silenced));
//        System.out.println("answerReq:" + answerReq);
        String jsonStr = objectMapper.writeValueAsString(answerReq);
        HttpResponse response = HttpRequest.post(url)
                .header("cookie", cookie)
                .header("Content-Type", "application/json;charset=utf8")
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .body(jsonStr).execute();
        if (response.isOk()) {
            String body = response.body();
            AnswerRes answerRes = objectMapper.readValue(body, AnswerRes.class);
            return answerRes.isSucceeded();
        } else {
            throw new RuntimeException("请求失败");
        }
    }

}
