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
    private Integer userid;

    private Integer friendid;

    private static final long serialVersionUID = 1L;
}