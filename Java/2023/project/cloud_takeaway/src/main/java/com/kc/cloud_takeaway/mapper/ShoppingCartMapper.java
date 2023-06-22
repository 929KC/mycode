package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【shopping_cart(购物车)】的数据库操作Mapper
* @createDate 2023-06-22 14:06:10
* @Entity com.kc.cloud_takeaway.model.entity.ShoppingCart
*/

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}




