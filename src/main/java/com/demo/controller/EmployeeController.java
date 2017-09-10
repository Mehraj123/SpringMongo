package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public boolean save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@GetMapping
	public List<Employee> searchAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("zip/{zipCode}")
	public List<Employee> searchByZipCode(@PathVariable("zipCode") String zipCode){
		return employeeService.getByZipCode(zipCode);
	}
}
