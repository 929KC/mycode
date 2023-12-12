package com.kc.hotel.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`admin`")
public class Admin {

    @TableId(value = "id")
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(value = "create_time")
    private Date createTime = new Date();
    @TableField(value = "email")
    private String email;
    @TableField(value = "admin_name")
    private String admin_name;
    @TableField(value = "password")
    private String password;
    @TableField(value = "phone")
    private String phone;


}
