package com.example.redisdemo.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "t_comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//评论id
    private String content;//评论内容
    private String author;//评论作者
    @Column(name="a_id")//指定映射的表字段名
    private Integer aId;//关联的文章id
}
