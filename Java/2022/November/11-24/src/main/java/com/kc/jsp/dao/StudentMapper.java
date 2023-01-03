package com.kc.jsp.dao;

import com.kc.jsp.model.Student;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/11/24 12:53
 * @description:
 */
public interface StudentMapper {
    List<Student> query();
}
