package com.demo.repository.custom;

import java.util.List;

import com.demo.entity.Employee;

/**
 * A custom repository for Employee
 * @author Mehraj Malik
 * @version 1.0
 */
public interface EmployeeCustomRepository {
	
	public List<Employee> findByZipCode(String zipCode);
}
