package com.Employee.EmployeeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Employee.EmployeeAPI.entity.Employee;
import com.Employee.EmployeeAPI.service.EmployeeService;

@RestController   //Ye class ko REST API Controller bana deta hai.Iske methods ka output JSON me Postman ko bheja jata hai.
@RequestMapping("/employees")  //Base URL set karta hai. sarin api http://localhost:8080/employees isi se start hongi
public class EmployeeController {

    @Autowired  //Spring automatically Service ka object de deta hai.
    EmployeeService service;

    @GetMapping   //Data fetch karne ke liye
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {  //URL se value leta hai.
        return service.getEmployee(id);
    }

    @PostMapping  //New data insert karne ke liye.
    public String createEmployee(@RequestBody Employee employee) {  //Request body (JSON) ko Java object me convert karta hai.
        return service.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}