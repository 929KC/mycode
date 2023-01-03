package com.kc.shoping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/12 9:55
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String name;
    private String trueName;
    private String cardId;
    private String email;
    private String telephone;
    private String qqId;
}
