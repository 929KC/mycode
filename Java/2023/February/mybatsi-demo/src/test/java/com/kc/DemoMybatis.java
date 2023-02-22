package com.kc;

import com.kc.mapper.EmployeeMapper;
import com.kc.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoMybatis {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    void selectTest() {
        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);
    }
    @Test
    void addTest() {
        Integer integer = employeeMapper.addEmployee(new Employee(5, "黄茂荣", 21, "boss"));
        if (integer>0) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    @Test
    void deleteTest() {
        Integer integer = employeeMapper.delEmployee(1);
        if (integer>0) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    @Test
    void upateTest() {
        Integer integer = employeeMapper.updateEmployee(2, "叶秋涵", 21, "高管");
        if (integer>0) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
