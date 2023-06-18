package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.entity.Employee;
import com.kc.cloud_takeaway.service.EmployeeService;
import com.kc.cloud_takeaway.mapper.EmployeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 929KC
 * @description 针对表【employee(员工信息)】的数据库操作Service实现
 * @createDate 2023-06-17 12:40:24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Override
    public BaseResponse<Employee> employeeLogin(String password, String username, HttpServletRequest request) {
        String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper<Employee> queryMapper = new QueryWrapper();
        queryMapper.eq("username", username);
        queryMapper.eq("password", encryptedPassword);
        Employee employee = this.baseMapper.selectOne(queryMapper);
        //e10adc3949ba59abbe56e057f20f883e
        if (employee == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (employee.getStatus() == 0) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        HttpSession session = request.getSession();
        session.setAttribute("employee", employee.getId());
        return ResultUtils.success(employee);
    }

    @Override
    public BaseResponse<String> employeeLogout(HttpServletRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        request.getSession().removeAttribute("employee");
        return ResultUtils.success(null);
    }

    @Override
    public BaseResponse<Page> employeeListPageQuery(Integer page, Integer pageSize, String name) {
        Page pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        this.page(pageInfo, lambdaQueryWrapper);
        return ResultUtils.success(pageInfo);
    }
}




