package com.techmahindra.springbootrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techmahindra.springbootrestapi.model.Employee;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {


	List<Employee> findByName(String name);

	// SELECT * FROM table WHERE name="Haridas" AND location="India"
	List<Employee> findByNameAndLocation(String name, String location);

	// SELECT * FROM table WHERE name LIKE "%Har%"
	// List<Employee>findByNameLike(String "%"+Keyword+"%");
	//List<Employee> findByNameContaining(String name);
    //Sorting
	List<Employee> findByNameContaining(String name, Sort sort);

	
	/**
	 * JPQL QUERY @Query("FROM EMPLOYEE WHERE name=:name OR location=:location")
	 * List<Employee> geteEmployeesByNameAndLocation(String name, String location);
	 **/
	
	/**
	 * Delete Record JPQL Query
	 
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee where name=:name")
	Integer deleteEmployeeByName(String name);
	**/
}