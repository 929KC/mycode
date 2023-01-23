package com.kc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.kc.anotaion.SystemLog)")
    public void pt() {

    }

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret;
        try {
            handleBefore();
            ret = joinPoint.proceed();
            handleAfter();
        } finally {
            // 结束后换行
            log.info("=======End=======" + System.lineSeparator());
        }
    }

    private void handleAfter() {
        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}",);
        // 打印描述信息
        log.info("BusinessName   : {}", );
        // 打印 Http method
        log.info("HTTP Method    : {}", );
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", );
        // 打印请求的 IP
        log.info("IP             : {}",);
        // 打印请求入参
        log.info("Request Args   : {}",);
        // 打印出参
        log.info("Response       : {}", );
    }

    private void handleBefore() {
        
    }
}
