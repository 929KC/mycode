package com.kc.web.dao;


import com.kc.web.model.MyClass;

import java.util.List;

public interface MyClassMapper {
    void addMyClass(int id ,String classname,String teacher,String professional);
    List<MyClass>  getMyClasses();
    void   deleteMyClasses(int id);
    void updateMyClasses(int id ,String classname,String teacher,String professional);
}
