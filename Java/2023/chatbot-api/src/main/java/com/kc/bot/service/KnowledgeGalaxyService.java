package com.kc.bot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kc.bot.model.UnAnsweredQuestionsAggregates;
import org.springframework.stereotype.Service;



public interface KnowledgeGalaxyService {
    UnAnsweredQuestionsAggregates  queryUnAnsweredQuestionsTopicId(String groupId,String cookie) throws JsonProcessingException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws JsonProcessingException;

}
