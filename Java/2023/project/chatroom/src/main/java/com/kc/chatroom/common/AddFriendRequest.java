package com.kc.chatroom.common;


import lombok.Data;

@Data
public class AddFriendRequest {
    private String type;
    private int fromUserId;
    private String fromUserName;
    private String reason;
}
