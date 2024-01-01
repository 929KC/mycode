package com.kc.bot;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kc.bot.model.Topics;
import com.kc.bot.model.UnAnsweredQuestionsAggregates;
import com.kc.bot.service.ChatGptService;
import com.kc.bot.service.KnowledgeGalaxyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BotTest {

    @Value("{chatbot-api.openaiKey}")
    private String openaiLey;

    @Value("{chatbot-api.cookie}")
    private String cookie;

    @Value("{chatbot-api.groupId}")
    private String groupId;
    @Resource
    private ChatGptService chatGptService;
    @Resource
    private KnowledgeGalaxyService knowledgeGalaxyService;

    @Test
    public void query() {
        String url = "https://api.zsxq.com/v2/groups/15552882441842/topics?scope=unanswered_questions&count=20";
        HttpResponse response = HttpRequest.get(url)
                .header("cookie", "abtest_env=product; zsxq_access_token=C2EFBA97-936C-8F29-7D99-AC6A50032BCC_58FC854B6E6F6E8E; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581228121218214%22%2C%22first_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fd16rg8unadx.feishu.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjODYwODYzZjMzYzYtMGVmOTBjMDI4NzQ0ZTU4LTI2MDAxOTUxLTEzMjcxMDQtMThjODYwODYzZjRhNSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTIyODEyMTIxODIxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581228121218214%22%7D%2C%22%24device_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%7D; zsxqsessionid=ddf4442052a8047f0647c4a795485b2c")
                .header("Content-Type", "application/json;charset=utf8").execute();
        System.out.println(response);
    }

    @Test
    public void answer() {
        String url = "https://api.zsxq.com/v2/topics/211425484442581/answer";
        HttpResponse response = HttpRequest.post(url)
                .header("cookie", "abtest_env=product; zsxq_access_token=C2EFBA97-936C-8F29-7D99-AC6A50032BCC_58FC854B6E6F6E8E; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581228121218214%22%2C%22first_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fd16rg8unadx.feishu.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjODYwODYzZjMzYzYtMGVmOTBjMDI4NzQ0ZTU4LTI2MDAxOTUxLTEzMjcxMDQtMThjODYwODYzZjRhNSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTIyODEyMTIxODIxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581228121218214%22%7D%2C%22%24device_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%7D; zsxqsessionid=ddf4442052a8047f0647c4a795485b2c")
                .header("Content-Type", "application/json;charset=utf8")
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .body("{\n" +
                        "  \"req_data\": {\n" +
                        "    \"text\": \"你好\\n\",\n" +
                        "    \"image_ids\": []\n" +
                        "  }\n" +
                        "}").execute();
        System.out.println(response);
    }

    @Test
    public void testChatGptPost() {
        String url = "https://api.openai.com/v1/chat/completions";
        String question = "nihao";
        String jsonStr = "{\"model\": \"gpt-3.5-turbo\",\"messages\": [{\"role\": \"user\",\"content\": \"" + question + "\"}],\"temperature\": 0.7}";
        HttpResponse response = HttpRequest.post(url)
                .setHttpProxy("127.0.0.1", 7890)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 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")
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .body(jsonStr)
                .execute();
        System.out.println(response);
    }

    @Test
    public void testUnAnsweredQuestionsAggregates() {
        try {
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = knowledgeGalaxyService.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void tesTaskChatGPT() throws JsonProcessingException {
        String s = chatGptService.askChatGPT("Bearer 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", "使用Java写一个快速排序");
        System.out.println(s);
    }

    @Test
    public void testAnswer() throws JsonProcessingException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = knowledgeGalaxyService.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            long topicId = topic.getTopic_id();
            boolean answer = knowledgeGalaxyService.answer(groupId, cookie, String.valueOf(topicId), topic.getQuestion().getText(), false);
            System.out.println(answer);
        }
    }
}
