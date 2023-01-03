package com.kc.dao;

import com.kc.model.domain.Student;


import java.util.List;

public interface StudentMapper {
    List<Student> getStudents(String classname) ;

}
