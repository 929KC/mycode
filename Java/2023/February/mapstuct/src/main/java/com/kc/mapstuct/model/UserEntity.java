package com.kc.mapstuct.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Long id;
    private Date gmtCreate;
    private Date createTime;
    private Long buyerId;
    private Long age;
    private String userNick;
    private String userVerified;
}

