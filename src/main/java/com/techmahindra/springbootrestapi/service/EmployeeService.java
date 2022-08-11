package com.techmahindra.springbootrestapi.service;

import java.util.List;

import com.techmahindra.springbootrestapi.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();
	//List<Employee>getEmployees(int pageNumber,int pageSize);

	Employee saveEmployee(Employee employee);

	Employee findbyEmloyeeId(Long id);

	Object deleteEmployee(Long id);

	Employee updateEmployee(Employee employee);

    List<Employee>getEmployeesByName(String name);

	List<Employee> getEmployeesByNameAndLocation(String name, String location);

	List<Employee> getEmployeesByKeyword(String name);

	
	//Integer deleteByEmployeeName(String name);

	//List<Employee> getEmployeesByNameOrLocation(String name, String location);
}
