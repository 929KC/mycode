package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-01-16 22:30:51
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
