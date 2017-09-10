package com.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.entity.Employee;
import com.demo.repository.custom.EmployeeCustomRepository;

/**
 * 
 * @author Mehraj Malik
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee,String>,EmployeeCustomRepository{

	public Employee findById(String id);
	public List<Employee> findByAddressZipCode(String zipCode);
}
