package com.bit.spring.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 18:18
 */
@Component
@Aspect//生成代理对象
@Order(3)
public class UserProxy {
    @Pointcut(value = " execution(* com.bit.spring.bean.User.add(..))")
    public void cut(){

    }
    //前置通知
    @Before(value = "execution(* com.bit.spring.bean.User.add(..))")
    public void before(){
        System.out.println("before");
    }
    //最终通知 方法执行后执行
    @After(value = "execution(* com.bit.spring.bean.User.add(..))")
    public void after(){
        System.out.println("After");
    }
    //环绕通知 方法执行之前之后都执行
    @Around(value = "execution(* com.bit.spring.bean.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.bit.spring.bean.User.add(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing");
    }

    //方法返回值后执行 后置通知
    @AfterReturning(value = "execution(* com.bit.spring.bean.User.add(..))")
    public void afterReturning(){
        System.out.println("AfterReturning");
    }
}
