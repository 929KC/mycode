package com.bit.spring.test;

import com.bit.spring.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-14 21:02
 */

public class BeanTest {
    @Test
    public void StudentTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context.getBean("Student", Student.class);
        Student student2 = context.getBean("Student", Student.class);
        System.out.println(student);
        System.out.println(student2);
    }

    @Test
    public void BookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void MybeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course mybean = context.getBean("mybean", Course.class);
        System.out.println(mybean);
    }

    @Test
    public void Teacher() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println("第四步创建对象");
        context.close();
    }

    @Test
    public void EmpTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }
}
