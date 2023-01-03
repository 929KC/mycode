package com.kc.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")//设置实体类所对应的表名
public class User {
    //将当前的属性所对应字段设置为主键,数据库中为id,这里为uid
    @TableId
    //value属性用于指定主键的字段,数据库中为uid，这里为id
    //type属性设置主键生成策越
    private Long id;
    private  String name;
    private Integer age;
    private String email;
}
