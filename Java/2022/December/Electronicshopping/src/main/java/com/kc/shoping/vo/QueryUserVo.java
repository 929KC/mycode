package com.kc.shoping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/12 10:28
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUserVo {
    private  int id;
    private String name;
    private String state;
}
