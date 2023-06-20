package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.DishFlavor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Mapper
* @createDate 2023-06-20 14:54:34
* @Entity com.kc.cloud_takeaway.model.entity.DishFlavor
*/
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {

}




