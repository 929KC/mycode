package com.kc.bitblog.controller;


import com.kc.bitblog.common.HttpResult;
import com.kc.bitblog.model.domain.Articleinfo;
import com.kc.bitblog.model.domain.Userinfo;
import com.kc.bitblog.service.ArticleService;
import com.kc.bitblog.utils.UserSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public HttpResult deleteArticle(HttpServletRequest request, Integer id) {
        if (id == null || id < 0) {
            return HttpResult.fail(-1, "参数异常");
        }
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo == null) {
            return HttpResult.fail(-1, "用户未登录");
        }
        return HttpResult.success(articleService.deleteArticle(id, userinfo.getId()));
    }

    @RequestMapping("/detail")
    public HttpResult getDetail(Integer id) {
        if (id == null || id < 0) {
            return HttpResult.fail(-1, "非法参数");
        }
        return HttpResult.success(articleService.getArticleDetailsById(id));
    }

    @RequestMapping("/incr-rcount")
    public HttpResult incrmentRCount(Integer id) {
        if (id != null && id > 0) {
            return HttpResult.success(articleService.incrementRCount(id));
        }
        return HttpResult.fail(-1, "非法参数");
    }

    @RequestMapping("/add")
    public HttpResult addArticle(Articleinfo articleinfo, HttpServletRequest request) {
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent())) {
            return HttpResult.fail(-1, "非法参数");
        }
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo == null || userinfo.getId() <= 0) {
            return HttpResult.fail(-1, "无效用户");
        }
        articleinfo.setRcount(userinfo.getId());
        return HttpResult.success(articleService.addArticle(articleinfo));
    }

    @RequestMapping("/update")
    public HttpResult updateArticle(Articleinfo articleinfo, HttpServletRequest request) {
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent())
                || articleinfo.getId() == null) {
            return HttpResult.fail(-1, "非法参数");
        }
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo == null || userinfo.getId() <= 0) {
            return HttpResult.fail(-1, "无效用户");
        }
        articleinfo.setUid(userinfo.getId());
        articleinfo.setUpdatetime(LocalDateTime.now());
        return HttpResult.success(articleService.updateArticle(articleinfo));
    }

    /**
     * @param pageSize  每页最大页数
     * @param pageIndex 页码
     * @return
     */
    @RequestMapping("/listbypage")
    public HttpResult getListByPage(Integer pageSize, Integer pageIndex) {
        if (pageSize == null || pageSize <= 1) {
            pageSize = 2;
        }
        if (pageIndex == null || pageIndex <= 1) {
            pageIndex = 1;
        }
        int offset = (pageIndex - 1) * pageSize;
        //文章列表的总条数
        int totalCount = articleService.getCount();
        double pcountdb = totalCount / pageSize * 1.0;
        int pcount = (int) Math.ceil(pcountdb);
        List<Articleinfo> mylist = articleService.getListByPage(pageSize, offset);
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("list", mylist);
        hashMap.put("pcount", pcountdb);
        return HttpResult.success(hashMap);
    }
}