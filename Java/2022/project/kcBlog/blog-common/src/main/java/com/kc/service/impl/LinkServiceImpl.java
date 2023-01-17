package com.kc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.utils.constants.SystemConstants;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.Link;
import com.kc.domain.vo.LinkVo;
import com.kc.mapper.LinkMapper;
import com.kc.service.LinkService;
import com.kc.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-01-16 22:30:51
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        List<LinkVo> linkVo = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        return ResponseResult.okResult(linkVo);
    }
}

