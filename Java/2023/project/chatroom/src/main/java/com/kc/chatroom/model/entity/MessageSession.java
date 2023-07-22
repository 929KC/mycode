package com.kc.chatroom.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @TableName message_session
 */
@TableName(value ="message_session")
@Data
public class MessageSession implements Serializable {
    private Integer sessionId;
    private List<Friend> friends;
    private Date lastTime;
    private String lastName;
    private static final long serialVersionUID = 1L;
}