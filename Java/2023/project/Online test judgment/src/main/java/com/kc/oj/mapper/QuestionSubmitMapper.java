package com.kc.oj.mapper;

import com.kc.oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【question_submit(题目提交)】的数据库操作Mapper
* @createDate 2023-09-13 13:44:23
* @Entity com.kc.oj.model.entity.QuestionSubmit
*/
@Mapper
public interface QuestionSubmitMapper extends BaseMapper<QuestionSubmit> {

}




