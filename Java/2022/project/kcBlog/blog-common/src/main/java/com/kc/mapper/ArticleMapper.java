package com.kc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;



/**
 * @author: 929KC
 * @date 2022/11/25 22:04
 * @description:
 * @version: 0.0.1
 **/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
