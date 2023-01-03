package com.kc.tools.model;

import lombok.Data;

/**
 * @author 929KC
 * @date 2022/11/23 21:32
 * @description:
 */
@Data
public class User {
    private Integer id;
    private String role;
    private String name;
    private String password;
    private  String id_card;
    private String phone;
    private String gender;
    private String entry_time;
    private String status;
}
