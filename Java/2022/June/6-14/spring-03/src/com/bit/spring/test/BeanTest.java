package com.bit.spring.test;

import com.bit.spring.bean.Student;
import com.bit.spring.bean.Teacher;
import com.bit.spring.bean.User;
import com.bit.spring.config.SpringConfig;
import com.bit.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 14:00
 */

public class BeanTest {
    @Test
    public void  StudnetTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
    @Test
    public void UserServiceTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.useDao();
    }
    @Test
    public void TeacherTest(){
        //纯注解开发
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
    @Test
    public void UserTest2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}

