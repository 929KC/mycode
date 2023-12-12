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
@TableName(value = "comment")
public class Comment {

    @TableId(value = "id")
    private Integer id;
    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value = "information")
    private String information;
    @TableField(value = "type")
    private Integer type;


}
