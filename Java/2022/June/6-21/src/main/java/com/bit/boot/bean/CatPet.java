package com.bit.boot.bean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-23 12:40
 */

public class CatPet {
    private String name;
    private int age;

    public CatPet() {
    }

    public CatPet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CatPet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
