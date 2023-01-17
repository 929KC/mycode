package com.kc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;


/**
 * 友链(Link)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-16 22:33:59
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}

