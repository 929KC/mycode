package com.kc.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/13 16:01
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private int id;
    private String title;
    private String content;
    private String time;
}
