package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2023-06-19 20:17:43
* @Entity com.kc.cloud_takeaway.model.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




