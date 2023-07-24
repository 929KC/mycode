package com.kc.chatroom.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
    private Integer sessionId;
    private List<Friend> friends;
    private Date lastTime;
    private String LastMessage;
    private static final long serialVersionUID = 1L;
}