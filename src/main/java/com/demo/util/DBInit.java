package com.demo.util;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Person;
import com.demo.repository.PersonRepository;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Component
public class DBInit implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;
	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		repository.save(new Person("Mehraj","Malik",new Date(),null));
		
	}

}
