package com.Employee.EmployeeAPI.service;
//Business logic likhna.
//Controller aur Repository ke beech bridge ka kaam karna.


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.EmployeeAPI.entity.Employee;

public interface EmployeeService{ //interface ka mtlb ye btata h kaun kaun se method honge but logic nhi likhta

    public List<Employee> getAllEmployees();

    public Employee getEmployee(@PathVariable int id);

    public String createEmployee(@RequestBody Employee employee);

    public String updateEmployee(@PathVariable int id,  //URL se value lene ke liye
                                 @RequestBody Employee employee); //JSON ko object me convert krta h

    public String deleteEmployee(@PathVariable int id);

}