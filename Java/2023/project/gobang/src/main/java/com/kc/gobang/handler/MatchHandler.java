package com.kc.gobang.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.gobang.game.MatchRequset;
import com.kc.gobang.game.MatchResponse;
import com.kc.gobang.game.Matcher;
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
    @Autowired
    private Matcher matcher;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            User user = (User) session.getAttributes().get("user");
            WebSocketSession tempSession = onlineUserManager.getSessionFromGameHall(user.getUserId());
            if (tempSession != null) {
                MatchResponse matchResponse = new MatchResponse();
                matchResponse.setOk(false);
                matchResponse.setReason("当前禁止多开");
                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(matchResponse)));
                session.close();
                return;
            }
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
        //实际处理开始匹配
        User user = (User) session.getAttributes().get("user");
        //获取客户端发送的数据
        String payload = message.getPayload();
        MatchRequset requset = objectMapper.readValue(payload, MatchRequset.class);
        MatchResponse response = new MatchResponse();
        if (requset.getMessage().equals("startMatch")) {
            matcher.add(user);
            response.setOk(true);
            response.setMessage("startMatch");
        } else if (requset.getMessage().equals("stopMatch")) {
            matcher.remove(user);
            response.setOk(true);
            response.setMessage("stopMatch");
        } else {
            response.setOk(false);
            response.setMessage("非法的请求匹配");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        try {

            User user = (User) session.getAttributes().get("user");
            WebSocketSession tempSession = onlineUserManager.getSessionFromGameHall(user.getUserId());
            if (tempSession == session) {
                onlineUserManager.exitGameHall(user.getUserId());
            }
            //如果玩家正在匹配中,而webSocket断开了,就应该移除匹配队列
            matcher.remove(user);
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
            WebSocketSession tempSession = onlineUserManager.getSessionFromGameHall(user.getUserId());
            if (session == tempSession) {
                onlineUserManager.exitGameHall(user.getUserId());
            }
            //如果玩家正在匹配中,而webSocket断开了,就应该移除匹配队列
            matcher.remove(user);
        } catch (NullPointerException e) {
            e.printStackTrace();
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setOk(false);
            matchResponse.setReason("你沒有登录!不能进行后续的匹配");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(matchResponse)));
        }
    }
}
