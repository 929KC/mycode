package com.kc.cloudsearch.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloudsearch.common.BaseResponse;
import com.kc.cloudsearch.common.ResultUtils;
import com.kc.cloudsearch.manager.SearchFacade;
import com.kc.cloudsearch.model.dto.post.PostQueryRequest;
import com.kc.cloudsearch.model.dto.search.SearchRequest;
import com.kc.cloudsearch.model.dto.user.UserQueryRequest;
import com.kc.cloudsearch.model.entity.Picture;
import com.kc.cloudsearch.model.vo.PostVO;
import com.kc.cloudsearch.model.vo.SearchVo;
import com.kc.cloudsearch.model.vo.UserVO;
import com.kc.cloudsearch.service.PictureService;
import com.kc.cloudsearch.service.PostService;
import com.kc.cloudsearch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

/**
 * 搜索接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVo> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }
}
