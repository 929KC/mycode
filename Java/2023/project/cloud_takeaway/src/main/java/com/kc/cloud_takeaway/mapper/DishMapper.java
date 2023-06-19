package com.kc.cloud_takeaway.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.cloud_takeaway.model.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2023-06-19 20:44:09
* @Entity generator.domain.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}




