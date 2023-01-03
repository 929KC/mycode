package com.bit.spring.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-14 20:47
 */

public class Student {
    private String[] course;
    private List<Course> list;
    private Map<String, String> map;
    private Set<String> set;

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }


    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "course=" + Arrays.toString(course) +
//                ", list=" + list +
//                ", map=" + map +
//                ", set=" + set +
//                '}';
//    }
}

