package com.kc.blog.model;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author 929KC
 * @date 2022/11/13 20:24
 * @description: 博客实体类
 */
@Data
@ToString
public class Blog {
    private int blogId;
    private String title ;
    private String content;
    private  int userId;
    private Timestamp postTime;

    //将发布日期格式化好并返回
    public String getPostTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(postTime);
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
