package com.kc.chatroom.common;

import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {
    private String type;
    private int fromId;
    private String fromName;
    private int sessionId;
    private String content;
    private Date postTime;
}