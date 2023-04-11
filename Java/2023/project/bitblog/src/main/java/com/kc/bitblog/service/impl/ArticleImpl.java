package com.kc.bitblog.service.impl;


import com.kc.bitblog.mapper.ArticleMapper;
import com.kc.bitblog.model.domain.Articleinfo;
import com.kc.bitblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int getArtCountByUid(Integer Uid) {
        return articleMapper.getArtCountByUid(Uid);
    }

    @Override
    public List<Articleinfo> getMyList(Integer uid) {
        return articleMapper.mylist(uid);
    }

    @Override
    public int deleteArticle(Integer id, Integer uid) {
        return articleMapper.deleteArticleById(id, uid);
    }
    @Override
    public Articleinfo getArticleDetailsById(Integer id) {
        return articleMapper.getArticleDetails(id);
    }
    @Override
    public int incrementRCount(Integer id) {
        return articleMapper.incrementRCount(id);
    }

    @Override
    public int addArticle(Articleinfo articleinfo) {
       return articleMapper.addArticle(articleinfo);
    }

    @Override
    public int updateArticle(Articleinfo articleinfo) {
        return articleMapper.updateArticle(articleinfo);
    }
}
