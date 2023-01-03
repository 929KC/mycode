package com.kc.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/13 8:22
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id ;
    private int userId;
    private String name;
    private String title ;
    private String content;
    private String time;
}
