package com.demo.repository.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entity.Employee;
import com.demo.repository.custom.EmployeeCustomRepository;

/**
 * An implemtation of EmployeeCustomRepository
 * @author Mehraj Malik
 * @version 1.0
 */
public class EmployeeRepositoryImpl implements EmployeeCustomRepository{
	
	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * Provides a list of employees of matched with the provided zipCode
	 * @author Mehraj Malik
	 * 
	 */
	@Override
	public List<Employee> findByZipCode(String zipCode) {
		Query findByZipCode = new Query(Criteria.where("address.zipCode").is(zipCode));
		//findByZipCode.fields().include("");
		return mongoOperations.find(findByZipCode, Employee.class);
	}

}
