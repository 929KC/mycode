package com.kc.hotel.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 标识为全局异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {

    // 捕获 Exception 类型的异常
    @ExceptionHandler(value = Exception.class)
    // 将方法返回值直接作为响应体
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        // 自定义异常处理逻辑
        String message = e.getMessage();
        e.printStackTrace();

        // 根据异常信息进行分类处理
        if (message.contains("(using password: YES)")) {
            if (!message.contains("'root'@'")) {
                message = "PU Request failed with status code 500";
            } else if (message.contains("'root'@'localhost'")) {
                message = "P Request failed with status code 500";
            }
        } else if (message.contains("Table") && message.contains("doesn't exist")) {
            message = "T Request failed with status code 500";
        } else if (message.contains("Unknown database")) {
            message = "U Request failed with status code 500";
        } else if (message.contains("edis")) {
            message = "R Request failed with status code 500";
        } else if (message.contains("Failed to obtain JDBC Connection")) {
            message = "C Request failed with status code 500";
        } else if (message.contains("SQLSyntaxErrorException")) {
            message = "S Request failed with status code 500";
        }

        // 返回自定义消息和 HTTP 状态码
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}