package com.kc.web.dao;


import com.kc.web.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents(String classname) ;

}
