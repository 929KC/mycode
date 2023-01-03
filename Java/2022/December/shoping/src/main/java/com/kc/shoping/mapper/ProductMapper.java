package com.kc.shoping.mapper;

import com.kc.shoping.model.Product;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 18:01
 * @description:
 */
public interface ProductMapper {
    List<Product> queryProducts();
    Product queryProductLike(String name);
}
