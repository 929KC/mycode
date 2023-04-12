package com.kc.bitblog.service;

import com.kc.bitblog.model.domain.Articleinfo;

import java.util.List;

public interface ArticleService {
    int getArtCountByUid(Integer Uid);

    List<Articleinfo> getMyList(Integer uid);

    int deleteArticle(Integer id, Integer uid);

    Articleinfo getArticleDetailsById(Integer id);

    int incrementRCount(Integer id);

    int addArticle(Articleinfo articleinfo);

    int updateArticle(Articleinfo articleinfo);
    List<Articleinfo> getListByPage(Integer pageSize ,Integer pageIndex);
    int getCount();
}
