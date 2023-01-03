package com.bit.spring.test;

import com.bit.spring.bean.Book;
import com.bit.spring.bean.Emp;
import com.bit.spring.bean.Orders;
import com.bit.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-14 16:51
 */

public class BeanTest {
    @Test
    public void BookTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.print(book);

    }

    @Test
    public void  Orders(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.print(orders);

    }

    @Test
    public void UserServiceTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("UserService", UserService.class);
        userService.add();
    }

    @Test
    public void EmpTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
