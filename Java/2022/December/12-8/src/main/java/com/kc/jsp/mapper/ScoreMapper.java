package com.kc.jsp.mapper;

import com.kc.jsp.model.AvgScore;

import java.util.List;
import java.util.Map;

/**
 * @author: 929KC
 * @date 2022/12/8 14:30
 * @description:
 * @version: 0.0.1
 **/
public interface ScoreMapper {
   Map<String,Object> queryAvg();
    List<AvgScore> queryAvg2();
}
