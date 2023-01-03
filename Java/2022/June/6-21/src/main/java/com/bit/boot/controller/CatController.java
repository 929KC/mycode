package com.bit.boot.controller;

import com.bit.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-25 21:34
 */
@RestController
public class CatController {
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
