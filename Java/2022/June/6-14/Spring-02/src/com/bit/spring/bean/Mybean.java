package com.bit.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 08:44
 */

public class Mybean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course c=new Course();
        c.setCname("java");
        return c;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
