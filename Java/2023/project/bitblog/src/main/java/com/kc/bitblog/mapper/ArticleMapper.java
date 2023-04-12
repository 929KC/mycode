package com.kc.bitblog.mapper;



import com.kc.bitblog.model.domain.Articleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    int getArtCountByUid(@Param("uid") Integer uid);
    List<Articleinfo> mylist(@Param("uid") Integer uid);
    int deleteArticleById(@Param("id") Integer id,@Param("uid") Integer uid);
    Articleinfo getArticleDetails(@Param("id") Integer id);
    int incrementRCount(@Param("id") Integer id);
    int addArticle(Articleinfo articleinfo);
    int updateArticle(Articleinfo articleinfo);
    List<Articleinfo> getListByPage(Integer pageSize ,Integer pageIndex);
    int getCount();
}
