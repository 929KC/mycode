package com.kc.jsp.mapper;

import com.kc.jsp.model.AvgScore;

import java.util.List;

/**
 * @author: 929KC
 * @date 2022/12/8 14:30
 * @description:
 * @version: 0.0.1
 **/
public interface ScoreMapper {
    List<AvgScore>  queryAvg();
}
