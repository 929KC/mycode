package com.kc.cloud_takeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.entity.Employee;
import com.kc.cloud_takeaway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;


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
    @PostMapping("/add")
    public BaseResponse<String> saveEmployee(HttpServletRequest request,@RequestBody Employee employe) {
        if (employe==null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        employe.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employe.setCreateTime(new Date());
        employe.setUpdateTime(new Date());
        Long id = (Long)request.getSession().getAttribute("employee");
        employe.setCreateUser(id);
        employe.setUpdateUser(id);
        employeeService.save(employe);
        return ResultUtils.success(null);
    }


    @PutMapping("/update")
    public BaseResponse<String> updateEmployee(HttpServletRequest request,@RequestBody Employee employe) {
        if (employe==null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = (Long)request.getSession().getAttribute("employee");
        employe.setUpdateUser(id);
        employe.setUpdateTime(new Date());
        employeeService.updateById(employe);
        return ResultUtils.success(null);
    }
    ///query/${id}
    @GetMapping("/query/{id}")
    public BaseResponse<Employee> queryEmployeeById(@PathVariable("id") Long id) {
        log.info("查询用户");
        Employee employee = employeeService.getById(id);
        if (employee!=null) {
            return ResultUtils.success(employee);
        }
        return ResultUtils.error(ErrorCode.NOT_QUERY_USE_ERROE);
    }
}
