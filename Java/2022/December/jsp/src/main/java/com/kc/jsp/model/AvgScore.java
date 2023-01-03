package com.kc.jsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/12/8 14:31
 * @description:
 */
@Data
@AllArgsConstructor
public class AvgScore {
    private String courseName;
    private String avgscore;
}
