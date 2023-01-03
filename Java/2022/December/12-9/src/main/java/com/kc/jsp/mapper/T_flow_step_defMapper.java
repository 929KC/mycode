package com.kc.jsp.mapper;

import com.kc.jsp.model.T_flow_step_def;
import com.kc.jsp.vo.T_flow_step_defVo;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/9 9:00
 * @description:
 */
public interface T_flow_step_defMapper {
    int  insert(T_flow_step_defVo t_flow_step_defVo);
    int   delete(int id);
    List<T_flow_step_def> queryAll();
}
