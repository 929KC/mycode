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
     *
     * @param groupId
     * @param cookie
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws JsonProcessingException {
        String url = "https://api.zsxq.com/v2/groups/15552882441842/topics?scope=unanswered_questions&count=20";
        HttpResponse response = HttpRequest.get(url)
                .header("cookie", "abtest_env=product; zsxq_access_token=C2EFBA97-936C-8F29-7D99-AC6A50032BCC_58FC854B6E6F6E8E; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581228121218214%22%2C%22first_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fd16rg8unadx.feishu.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjODYwODYzZjMzYzYtMGVmOTBjMDI4NzQ0ZTU4LTI2MDAxOTUxLTEzMjcxMDQtMThjODYwODYzZjRhNSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTIyODEyMTIxODIxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581228121218214%22%7D%2C%22%24device_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%7D; zsxqsessionid=ddf4442052a8047f0647c4a795485b2c")
                .header("Content-Type", "application/json;charset=utf8").execute();
        String responseBody = response.body();
        if (response.isOk()) {
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = objectMapper.readValue(responseBody, UnAnsweredQuestionsAggregates.class);
            return unAnsweredQuestionsAggregates;
        } else {
            throw  new RuntimeException("请求失败");
        }
    }

    /**
     *
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
        String url = "https://api.zsxq.com/v2/topics/"+topicId+"/answer";
        AnswerReq answerReq = new AnswerReq(new ReqData(text,silenced));

        System.out.println("answerReq:"+answerReq);
        String jsonStr= objectMapper.writeValueAsString(answerReq);
        System.out.println("jsonStr:"+jsonStr);
        HttpResponse response = HttpRequest.post(url)
                .header("cookie", "abtest_env=product; zsxq_access_token=C2EFBA97-936C-8F29-7D99-AC6A50032BCC_58FC854B6E6F6E8E; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581228121218214%22%2C%22first_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fd16rg8unadx.feishu.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjODYwODYzZjMzYzYtMGVmOTBjMDI4NzQ0ZTU4LTI2MDAxOTUxLTEzMjcxMDQtMThjODYwODYzZjRhNSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTIyODEyMTIxODIxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581228121218214%22%7D%2C%22%24device_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%7D; zsxqsessionid=ddf4442052a8047f0647c4a795485b2c")
                .header("Content-Type", "application/json;charset=utf8")
                .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .body(jsonStr).execute();
        if (response.getStatus()==200) {
            String body = response.body();
            AnswerRes answerRes = objectMapper.readValue(body,AnswerRes.class);
            System.out.println("answerReq:"+answerReq);
            System.out.println("flag:"+answerRes.isSucceeded());
            return answerRes.isSucceeded();
        }else {
            throw  new RuntimeException("请求失败");
        }
    }

}
