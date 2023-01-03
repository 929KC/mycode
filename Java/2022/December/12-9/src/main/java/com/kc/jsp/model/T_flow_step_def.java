package com.kc.jsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/12/9 8:41
 * @description:
 */
@Data
@AllArgsConstructor
public class T_flow_step_def {
    private int Step_no ;
    private String Step_name ;
    private int Limit_time ;
    private String Step_des;
    private String URL;
}
