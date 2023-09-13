package com.kc.oj.mapper;

import com.kc.oj.model.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2023-09-13 13:44:23
* @Entity com.kc.oj.model.entity.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




