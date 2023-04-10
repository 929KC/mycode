package com.kc.bitblog.service;

import com.kc.bitblog.model.domain.Articleinfo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    int getArtCountByUid(Integer Uid);
    List<Articleinfo> getMyList(Integer uid);
    int deleteArticle(Integer id,Integer uid);
    Articleinfo getArticleDetailsById(Integer id);
}
