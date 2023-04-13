package com.kc.cloudsearch.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.kc.cloudsearch.common.BaseResponse;
import com.kc.cloudsearch.common.ErrorCode;
import com.kc.cloudsearch.common.ResultUtils;
import com.kc.cloudsearch.exception.ThrowUtils;
import com.kc.cloudsearch.model.dto.picture.PictureQueryRequest;
import com.kc.cloudsearch.model.entity.Picture;
import com.kc.cloudsearch.service.PictureService;;
import com.kc.cloudsearch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;

    private final static Gson GSON = new Gson();
    /**
     * 分页搜索（从 ES 查询，封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/search/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                          HttpServletRequest request) {
        long size = pictureQueryRequest.getPageSize();
        String searchText = pictureQueryRequest.getSearchText();
        long current = pictureQueryRequest.getCurrent();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Picture> picturePage = pictureService.searchPicture(searchText,current,size);
        return ResultUtils.success(picturePage);
    }
}
