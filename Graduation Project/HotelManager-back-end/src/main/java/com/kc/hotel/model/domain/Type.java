package com.kc.hotel.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "type")
public class Type {

    @TableId(value = "id")
    private Integer id;
    @TableField(value = "type_name")
    private String typeName;
    @TableField(value = "price")
    private Double price;
    @TableField(value = "introduce")
    private String introduce;
    @TableField(value = "feature")
    private String feature;
    @TableField(value = "cover_image")
    private String coverImage;
    @TableField(value = "detail_url")
    private String detailUrl;


}
