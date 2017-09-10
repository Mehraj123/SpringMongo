package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {

	public boolean save(Employee address);
	public List<Employee> getAll();
	public List<Employee> getByZipCode(String zipCode);
}
