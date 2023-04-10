package com.kc.bitblog.controller;


import com.kc.bitblog.common.HttpResult;
import com.kc.bitblog.model.domain.Articleinfo;
import com.kc.bitblog.model.domain.Userinfo;
import com.kc.bitblog.service.ArticleService;
import com.kc.bitblog.utils.UserSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/art")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public HttpResult getMylist(HttpServletRequest request) {
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo == null) {
            return HttpResult.fail(-1, "非法参数");
        }
        List<Articleinfo> myList = articleService.getMyList(userinfo.getId());
        return HttpResult.success(myList);
    }
    @RequestMapping("/del")
    public HttpResult deleteArticle(HttpServletRequest request,Integer id) {
        if (id == null||id<0) {
            return HttpResult.fail(-1, "参数异常");
        }
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo == null) {
            return HttpResult.fail(-1, "用户未登录");
        }
        return HttpResult.success(articleService.deleteArticle(id,userinfo.getId()));
    }
    @RequestMapping("/detail")
    public HttpResult getDetail(Integer id){
        if (id == null||id<0) {
            return HttpResult.fail(-1,"非法参数");
        }
        return HttpResult.success(articleService.getArticleDetailsById(id));
    }
}
