package com.bit.spring.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 20:05
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value="execution(* com.bit.spring.bean.User.add(..))")
    public void before(){
        System.out.println("Person Before");
    }
}
