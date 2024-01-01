//package com.kc.bot.job;
//
//
//import com.kc.bot.model.Topics;
//import com.kc.bot.model.UnAnsweredQuestionsAggregates;
//import com.kc.bot.service.ChatGptService;
//import com.kc.bot.service.KnowledgeGalaxyService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Random;
//@Slf4j
//@Component
//public class ChatBotSchedule {
//
//    @Value("${chatbot-api.group01.openaiKey}")
//    private String openaiKey;
//
//    @Value("${chatbot-api.group01.cookie}")
//    private String cookie;
//
//    @Value("${chatbot-api.group01.groupId}")
//    private String groupId;
//    @Resource
//    private  ChatGptService chatGptService;
//    @Resource
//    private KnowledgeGalaxyService knowledgeGalaxyService;
//    @Scheduled(cron = "0 */1 * * * ?")
//    public void run () {
//        try {
//            if (new Random().nextBoolean()) {
//                log.info("随机打印中.....");
//            }
//            //1.查询出没有回答的问题
//            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = knowledgeGalaxyService.queryUnAnsweredQuestionsTopicId(groupId, cookie);
//            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
//            if (topics==null||topics.isEmpty()) {
//                log.info("没有未等待回答的问题");
//                return;
//            }
//            Topics topic = topics.get(topics.size() - 1);
//            //2.使用AI回答
//            String answer = chatGptService.askChatGPT(openaiKey,topic.getQuestion().getText().trim());
//            //3.回答问题
//            boolean status = knowledgeGalaxyService.answer(groupId, cookie, String.valueOf(topic.getTopic_id()), answer, false);
//            log.info("回答问题结果:"+status+" groupId:"+groupId+" getTopic_id:"+topic.getTopic_id()+" answer:"+answer);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
