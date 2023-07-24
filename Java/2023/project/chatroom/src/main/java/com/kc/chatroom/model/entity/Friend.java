package com.kc.chatroom.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName friend
 */
@TableName(value ="friend")
@Data
public class Friend implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private Integer friendId;
    private String friendName;
    private static final long serialVersionUID = 1L;
}