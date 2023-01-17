package com.kc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;



/**
 * 分类表(Category)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-26 14:17:38
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
