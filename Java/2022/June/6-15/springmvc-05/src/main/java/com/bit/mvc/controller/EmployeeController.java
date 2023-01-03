package com.bit.mvc.controller;
import com.bit.mvc.bean.Employee;
import com.bit.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-19 12:45
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao ed;

    @RequestMapping(value = "/employee",method= RequestMethod.GET)
    public String getAllEmployees(Model model){
    Collection<Employee> employeeList = ed.getAll();
    model.addAttribute("employeeList",employeeList);
    return "employee_list";
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        ed.delete(id);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        ed.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeByid(@PathVariable("id") Integer id,Model model){
        Employee employee=ed.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        ed.save(employee);
        return "redirect:/employee";
    }
}
