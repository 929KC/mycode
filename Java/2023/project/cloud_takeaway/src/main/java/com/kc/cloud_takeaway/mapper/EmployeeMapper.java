package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2023-06-17 12:40:24
* @Entity com.kc.cloud_takeaway.model.entity.Employee
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}




