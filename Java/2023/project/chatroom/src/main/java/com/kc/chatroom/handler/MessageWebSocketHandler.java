package com.kc.chatroom.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.chatroom.common.MessageRequest;
import com.kc.chatroom.common.MessageResponse;
import com.kc.chatroom.mapper.MessageMapper;
import com.kc.chatroom.mapper.MessageSessionMapper;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.Message;
import com.kc.chatroom.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


@Component
public class MessageWebSocketHandler extends TextWebSocketHandler {
    @Resource
    private OnlineUserManagerHandler onlineUserManagerHandler;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    private MessageSessionMapper messageSessionMapper;
    @Resource
    private MessageMapper messageMapper;

    public MessageWebSocketHandler() {
        System.out.println("MessageWebSocketHandler load");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("websocket 连接成功!");
        try {
            User user = (User) session.getAttributes().get("user");
            onlineUserManagerHandler.onLine(user.getUserId(), session);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("websocket 收到消息!");
        try {
            User user = (User) session.getAttributes().get("user");
            MessageRequest req = objectMapper.readValue(message.getPayload(), MessageRequest.class);
            if ("message".equals(req.getType())) {
                // 处理消息请求
                handlerMessage(user, req);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("websocket 连接异常!");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("websocket 连接关闭!");
        try {
            User user = (User) session.getAttributes().get("user");
            onlineUserManagerHandler.offLine(user.getUserId(), session);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void handlerMessage(User user, MessageRequest req) throws IOException {
        //1.构造响应
        MessageResponse resp = new MessageResponse();
        resp.setType("message");
        resp.setFromId(user.getUserId());
        resp.setFromName(user.getUsername());
        resp.setSessionId(req.getSessionId());
        resp.setContent(req.getContent());
        resp.setPostTime(new Timestamp(System.currentTimeMillis()));
        String respJson = objectMapper.writeValueAsString(resp);
        System.out.println("[handlerMessage] resp:" + respJson);
        //2.根据请求中的sessionId,在数据库中找到所有的userId
        List<Friend> friends = messageSessionMapper.selectFriendsBySessionId(req.getSessionId());
        //要把自己也加入到列表中
        Friend friend = new Friend();
        friend.setFriendId(user.getUserId());
        friend.setFileName(user.getUsername());
        friends.add(friend);
        System.out.println("[handlerMessage] 要转发给那些人:" + friends);
        //根据每个userId，找到webSocketSession并转发消息
        for (Friend friend1 : friends) {
            WebSocketSession webSocketSession = onlineUserManagerHandler.getSession(friend1.getUserId());
            if (webSocketSession == null) {
                // 如果⽤⼾没在线就不管了.
                continue;
            }
            webSocketSession.sendMessage(new TextMessage(respJson));
        }
        // 4. 把这个消息写⼊数据库
        Message message = new Message();
        message.setFromId(resp.getFromId());
        message.setSessionId(resp.getSessionId());
        message.setContent(resp.getContent());
        message.setPostTime(resp.getPostTime());
        messageMapper.insert(message);
    }
}
