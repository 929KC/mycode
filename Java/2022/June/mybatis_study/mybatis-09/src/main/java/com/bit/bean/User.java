package com.bit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 22:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  int id;
    private String name;
    private String pwd;
}
