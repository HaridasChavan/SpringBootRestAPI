package com.techmahindra.springbootrestapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techmahindra.springbootrestapi.model.Employee;
import com.techmahindra.springbootrestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeRepository eRepository;

	
	  @Override public List<Employee> getEmployees() { 
		  return (List<Employee>) eRepository.findAll();
	  }
	
	/** pagination

	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return eRepository.findAll(pages).getContent();
	}
*/
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public Employee findbyEmloyeeId(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id" + id);
	}

	@Override
	public Object deleteEmployee(Long id) {
		try {
			eRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		logger.info("Employee deleted Successfully");
		return new ResponseEntity<>("Employee deleted succesfully", HttpStatus.OK);

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name, location);
	}

	/**
	 * @Override public List<Employee> getEmployeesByKeyword(String name) { return
	 *           eRepository.findByNameContaining(name); }
	 **/
	// Sorting
	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return eRepository.findByNameContaining(name, sort);
	}

	/***
	 * @Override public List<Employee> getEmployeesByNameOrLocation(String name,
	 *           String location) { return
	 *           eRepository.geteEmployeesByNameAndLocation(name,location); }
	 **/
	/**
	 * @Override public String deleteByEmployeeName(String name) { return
	 *           eRepository.deleteEmployeeByName(name);
	 * 
	 **/

}
