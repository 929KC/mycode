package com.kc.gobang.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.gobang.game.MatchResponse;
import com.kc.gobang.game.OnlineUserManager;
import com.kc.gobang.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MatchHandler extends TextWebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private OnlineUserManager onlineUserManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            User user = (User) session.getAttributes().get("user");
            onlineUserManager.enterGameHall(user.getUserId(), session);
        } catch (NullPointerException e) {
            e.printStackTrace();
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setOk(false);
            matchResponse.setReason("你沒有登录!不能进行后续的匹配");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(matchResponse)));
        }

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        try {
            User user = (User) session.getAttributes().get("user");
            onlineUserManager.exitGameHall(user.getUserId());
        } catch (NullPointerException e) {
            e.printStackTrace();
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setOk(false);
            matchResponse.setReason("你沒有登录!不能进行后续的匹配");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(matchResponse)));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        try {
            User user = (User) session.getAttributes().get("user");
            onlineUserManager.exitGameHall(user.getUserId());
        }catch (NullPointerException e) {
            e.printStackTrace();
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setOk(false);
            matchResponse.setReason("你沒有登录!不能进行后续的匹配");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(matchResponse)));
        }
    }
}
