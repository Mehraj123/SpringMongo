package com.demo.util;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Address;
import com.demo.entity.Employee;
import com.demo.entity.Person;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.PersonRepository;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Component
public class DBInit implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*@Autowired
	private PersonRepository repository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		//System.out.println("---- StartDate : ---"+startDate);
		//System.out.println("-----End Date : ----"+endDate);
		//System.out.println("Local Time : "+LocalTime.now());
		
		Person person = new Person("A","B",LocalDate.now(Clock.systemUTC()),LocalDate.of(2020,01,01));
		repository.save(person);
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address("11"));
		Employee employee = new Employee("Mehraj", addresses);
		employeeRepository.save(employee);
		System.out.println("Data saved");
	}*/

}
