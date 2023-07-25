package com.kc.chatroom.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

/**
 * @TableName message
 */
@TableName(value ="message")
@Data
public class Message implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer messageId;
    /**
     * 谁发的
     */
    private Integer fromId;
    /**
     * 发给那个会话
     */
    private Integer sessionId;

    private String content;

    private Date postTime;
    public String getPostTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(postTime);
    }
    private static final long serialVersionUID = 1L;
}