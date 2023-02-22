package com.kc.mapper;


import com.kc.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

    Employee getEmployeeById(@Param(value = "id") Integer id);
    Integer addEmployee(Employee employee);
    Integer delEmployee(@Param(value = "id") Integer id);
    Integer updateEmployee(@Param(value = "id") Integer id, @Param(value ="name") String name, @Param(value ="age") Integer age,@Param(value = "position")
     String position);

}
