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
@TableName(value = "room")
public class Room {

    @TableId(value = "id")
    private Integer id;
    @TableField(value = "number")
    private String number;
    @TableField(value = "type")
    private Integer type;
    @TableField(value = "state")
    private Integer state = 0;
    @TableField(value = "max_people")
    private Integer maxPeople;
    @TableField(value = "introduce")
    private String introduce;


}
