package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Address;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getByZipCode(String zipCode) {
		return employeeRepository.findByAddressZipCode(zipCode);
	}

	@Override
	public boolean save(Employee address) {
		try {
			employeeRepository.save(address);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
