package com.kc.chatroom.common;

import lombok.Data;

@Data
public class MessageRequest {
    private String type;
    private int sessionId;
    private String content;
}