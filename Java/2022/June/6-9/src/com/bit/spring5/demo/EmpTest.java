package com.bit.spring5.demo;

import com.bit.spring5.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 21:38
 */

public class EmpTest {
    @Test
    public void EmpTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Emp e=context.getBean("emp",Emp.class);
        e.print();
    }

}
