package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.Article;


/**
 * @author: 929KC
 * @date 2022/11/25 22:06
 * @description:
 * @version: 0.0.1
 **/

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getAttachmentDetail(Long id);
}
