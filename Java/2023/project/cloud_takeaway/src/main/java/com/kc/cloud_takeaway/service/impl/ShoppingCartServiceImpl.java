package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.model.entity.ShoppingCart;
import com.kc.cloud_takeaway.service.ShoppingCartService;
import com.kc.cloud_takeaway.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2023-06-22 14:06:10
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




