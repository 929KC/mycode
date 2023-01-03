package com.bit.spring5.demo;

import com.bit.spring5.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 20:01
 */

public class StudentTest {
    @Test
    public void studentTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        Student s=context.getBean("student",Student.class);
        s.print();
    }
}
