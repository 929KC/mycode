package com.bit.dao;


import com.bit.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TeacherMapper {
  //获取指定老师下的所有学生及老师信息
  List<Teacher> getTeacher(@Param("tid") int id);
}
