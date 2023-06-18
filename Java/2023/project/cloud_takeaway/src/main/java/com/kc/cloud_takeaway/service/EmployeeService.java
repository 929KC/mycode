package com.kc.cloud_takeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.model.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import javax.servlet.http.HttpServletRequest;

/**
* @author 929KC
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2023-06-17 12:40:24
*/
public interface EmployeeService extends IService<Employee> {
    BaseResponse<Employee> employeeLogin(String password, String username, HttpServletRequest request);
    BaseResponse<String> employeeLogout( HttpServletRequest request);
    BaseResponse<Page> employeeListPageQuery(Integer page, Integer pageSize, String name);
}
