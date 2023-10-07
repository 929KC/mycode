package com.example.redisdemo.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity(name = "t_article")
public class Article {
    @Id
    private Integer id;//文章id
    private String title;//文章标题
    private String content;//文章内容

}
