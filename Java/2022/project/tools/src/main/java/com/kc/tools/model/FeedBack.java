package com.kc.tools.model;

import lombok.Data;

import java.util.Date;

/**
 * @author 929KC
 * @date 2022/11/24 7:42
 * @description:
 */
@Data
public class FeedBack {
    private String id;
    private String content;
    private int type;
    private int contactWay;
    private Date  createTime;
}
