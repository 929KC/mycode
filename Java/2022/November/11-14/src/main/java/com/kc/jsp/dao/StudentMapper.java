package com.kc.jsp.dao;

import com.kc.jsp.model.Student;

import java.util.List;

/**
 * @author: 929KC
 * @date 2022/11/28 7:38
 * @description:
 * @version: 0.0.1
 **/
public interface StudentMapper {
    List<Student> queryAll();
    void insert(Student student);
}
