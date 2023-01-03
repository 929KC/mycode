//package com.kc.web.model;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//
///**
// * @author 929KC
// * @date 2022/11/14 16:39
// * @description:
// */
//public class JacksonTest {
//
//    @Test
//    public void studentJson() {
//        Student student = new Student();
//        student.setId(1);
//        student.setUserName("叶秋涵");
//        student.setSex("女");
//        student.setAge(19);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String json = mapper.writeValueAsString(student);
//            System.out.println(json);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//}
