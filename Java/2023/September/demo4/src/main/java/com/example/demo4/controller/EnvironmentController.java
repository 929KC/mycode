package com.example.demo4.controller;


import com.example.demo4.config.DBConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EnvironmentController {
    @Resource
    private DBConnector connector;

    @GetMapping("/demo")
    public void getEnvironment() {
        connector.run();
    }
}
