package com.kc.chatroom.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName message_session_user
 */
@TableName(value ="message_session_user")
@Data
public class MessageSessionUser implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer sessionId;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}