package com.kc.mybatis.dao.impl;

import com.kc.mybatis.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 929KC
 * @date 2022/11/22 12:22
 * @description:
 */
public interface StudentMapper {
     int addStudent(Student student);
    int  deleteStudent(int id);
    List<Student>  getStudentList();
    Student getStudentById(int id);
    int updateStudent(Student student);
    List<Student> getStudentByAgeDesc(String sort);
    List<Student> selectByParamMap(Map<String,Object> paramMap);
    /**
     *
     * @author 929KC
     * @date 2022/11/22 2022/11/22
     * @param startIndex 页码
     * @param pageSize 每页显示记录条数
     * @return List<Student>
     */
    List<Student> selectAllByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
}
