package com.kc.jsp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/12/9 8:59
 * @description:
 */
@Data
@AllArgsConstructor
public class T_flow_step_defVo {
    private String Step_name ;
    private int Limit_time ;
    private String Step_des;
    private String URL;
}
