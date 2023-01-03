package com.kc.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
