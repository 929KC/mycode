package com.bit.bean;

import lombok.Data;

import java.util.Date;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 18:57
 */
@Data
public class Blog {
    private int id;
    private  String name;
    private String title;
    private Date createTime;
    private int views;
    private String author;

}
