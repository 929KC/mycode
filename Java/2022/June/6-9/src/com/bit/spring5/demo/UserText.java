package com.bit.spring5.demo;

import com.bit.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 07:39
 */

public class UserText {
    @Test
    public void textPrint(){
        //1.加载spring配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取配置创建的对象
        User  user=context.getBean("user",User.class);
       user.print();
    }

}
