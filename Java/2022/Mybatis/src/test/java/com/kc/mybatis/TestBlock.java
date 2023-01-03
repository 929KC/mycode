package com.kc.mybatis;

import com.kc.mybatis.mapper.ProductMapper;
import com.kc.mybatis.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBlock {
    @Autowired
    private ProductMapper productMapper ;
    @Test
    public void test(){
        //1、小李
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格：" + p1.getPrice());
        //2、小王
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格：" + p2.getPrice());
        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1); //4、小王将商品减了30元，存入了数据库
         p2.setPrice(p2.getPrice() - 30);
         int result2 = productMapper.updateById(p2);
         System.out.println("小王修改结果：" + result2);
         //最后的结果
        Product p3 = productMapper.selectById(1L);
        //价格覆盖，最后的结果：70\
        System.out.println("最后的结果：" + p3.getPrice());
    }
}
