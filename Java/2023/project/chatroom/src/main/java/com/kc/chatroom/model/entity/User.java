package com.kc.chatroom.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}