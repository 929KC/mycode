package com.kc.shoping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/13 8:28
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo {
    private String title;
    private String content;
    private String time;
}
