package com.bit.mvc.bean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-19 16:58
 */

public class Student {
    private String name;
    private String sex;
    private String school;
    private String address;

    public Student() {
    }

    public Student(String name, String sex, String school, String address) {
        this.name = name;
        this.sex = sex;
        this.school = school;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
