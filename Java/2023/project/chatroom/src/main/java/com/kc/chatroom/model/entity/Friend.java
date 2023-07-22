package com.kc.chatroom.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName friend
 */
@TableName(value ="friend")
@Data
public class Friend implements Serializable {
    private Integer userId;
    private String fileName;
    private Integer friendId;
    private static final long serialVersionUID = 1L;
}