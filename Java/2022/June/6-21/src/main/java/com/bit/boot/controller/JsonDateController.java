package com.bit.boot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-23 07:41
 */
@RestController
public class JsonDateController {
    @RequestMapping("/json2")
    public String dateTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //让它不返回时间戳,所以需要关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置指定的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);
        //获取日期对象
        Date date = new Date();
        return mapper.writeValueAsString(date);
    }
}
