package com.kc.cloud_takeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.entity.Employee;
import com.kc.cloud_takeaway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/login")
    public BaseResponse<Employee> login(HttpServletRequest request, @RequestBody Employee employe) {
        if (employe==null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        System.out.println(employe);
        String username = employe.getUsername();
        String password = employe.getPassword();
        if (StringUtils.isAnyBlank(username,password)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return employeeService.employeeLogin(password, username,request);
    }

    @PostMapping("/logout")
    public BaseResponse<String> logout(HttpServletRequest request) {
        log.info("退出");
        return employeeService.employeeLogout(request);
    }

    @GetMapping("/page")
    public BaseResponse<Page> pageQuery(Integer page,Integer pageSize,String name) {
        log.info("page= {},pageSize= {},name= {}",page,pageSize,name);
        if (page == null||pageSize == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
       return employeeService.employeeListPageQuery(page, pageSize, name);
    }
}
