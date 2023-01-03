package com.kc.jsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/12/8 13:36
 * @description:
 */
@Data
@AllArgsConstructor
public class Scores {
    private int id;
    private String score;
    private String courseId;
}
