package com.Employee.EmployeeAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Employee.EmployeeAPI.entity.Employee;

//Spring ko btata h ki ye repository layer h jo database se bat krega
//repository ko interface bnaya jata , iska object hme manualy nhi banana pdta , spring boot khud bna deta h
//jpaRepository--CRUD methods pehle se mil jate hain, isliye hume SQL queries ya methods manually nahi likhne padte.
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
	
}
