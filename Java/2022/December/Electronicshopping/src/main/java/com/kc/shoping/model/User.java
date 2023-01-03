package com.kc.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/12 16:24
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String trueName;
    private String cardId;
    private String email;
    private String telephone;
    private String qqId;
    private String regTime;
    private String question;
    private String answer;
    private String state;
}
