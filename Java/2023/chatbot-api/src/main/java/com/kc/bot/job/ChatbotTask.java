package com.kc.bot.job;


import com.alibaba.fastjson.JSON;
import com.kc.bot.model.Topics;
import com.kc.bot.model.UnAnsweredQuestionsAggregates;
import com.kc.bot.service.ChatGptService;
import com.kc.bot.service.KnowledgeGalaxyService;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

@Slf4j
public class ChatbotTask implements Runnable {



    private String groupName;
    private String groupId;
    private String cookie;
    private String openAiKey;
    private boolean silenced;

    private KnowledgeGalaxyService  knowledgeGalaxyService;
    private ChatGptService chatGptService;

    public ChatbotTask(String groupName, String groupId, String cookie, String openAiKey, boolean silenced, KnowledgeGalaxyService knowledgeGalaxyService, ChatGptService chatGptService) {
        this.groupName = groupName;
        this.groupId = groupId;
        this.cookie = cookie;
        this.openAiKey = openAiKey;
        this.silenced = silenced;
        this.knowledgeGalaxyService = knowledgeGalaxyService;
        this.chatGptService = chatGptService;
    }

    @Override
    public void run() {
        try {

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                log.info("{} 打烊时间不工作，AI 下班了！", groupName);
                return;
            }

            // 1. 检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = knowledgeGalaxyService.queryUnAnsweredQuestionsTopicId(groupId, cookie);
            log.info("{} 检索结果：{}", groupName, JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (null == topics || topics.isEmpty()) {
                log.info("{} 本次检索未查询到待会答问题", groupName);
                return;
            }
            // 2. AI 回答
            Topics topic = topics.get(topics.size() - 1);
            String answer = chatGptService.askChatGPT(openAiKey, topic.getQuestion().getText().trim());
            // 3. 问题回复
            boolean status = knowledgeGalaxyService.answer(groupId, cookie, String.valueOf(topic.getTopic_id()), answer, silenced);
            log.info("{} 编号：{} 问题：{} 回答：{} 状态：{}", groupName, topic.getTopic_id(), topic.getQuestion().getText(), answer, status);
        } catch (Exception e) {
            log.error("{} 自动回答问题异常", groupName, e);
        }
    }

}
