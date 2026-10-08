package com.Employee.EmployeeAPI.serviceImpl;

import com.Employee.EmployeeAPI.service.EmployeeService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.EmployeeAPI.entity.Employee;
import com.Employee.EmployeeAPI.exception.EmployeeNotFoundException;
import com.Employee.EmployeeAPI.repository.EmployeeRepository;

@Service  //Ye Service Layer hai. Aur Spring iska object (Bean) automatically bana deta hai.
public class EmployeeServiceImpl implements EmployeeService{
	
	  @Autowired     //
	    EmployeeRepository repository;

	    @Override
	    public List<Employee> getAllEmployees() {

	        return repository.findAll();
	    }

	    @Override
	    public Employee getEmployee(int id) {

	        Employee employee = repository.findById(id).orElse(null);

	        if(employee == null) {
	            throw new EmployeeNotFoundException("Employee is not found!! " + id);
	        }

	        return employee;
	    }

	    @Override
	    public String createEmployee(Employee employee) {

	        repository.save(employee);
	        return "Employee Added";
	    }

	    @Override
	    public String updateEmployee(int id, Employee employee) {

	        Employee e = repository.findById(id).orElse(null);
	        System.out.println(employee.getDepartment());

	        if(e != null) {
	            e.setName(employee.getName());
	            e.setDepartment(employee.getDepartment());
	            e.setSalary(employee.getSalary());

	            repository.save(e);

	            return "Employee Updated";
	        }

	        else {
	            throw new EmployeeNotFoundException("Employee is not found!! " + id);
	        }

	    }

	    @Override
	    public String deleteEmployee(int id) {

	        Employee employee = repository.findById(id).orElse(null);

	        if(employee != null) {

	            repository.delete(employee);

	            return "Employee Deleted";
	        }

	        else {
	            throw new EmployeeNotFoundException("Employee is not found!! " + id);
	        }

	    }

	}
