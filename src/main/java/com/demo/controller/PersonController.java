package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Person;
import com.demo.service.PersonService;

/**
 * 
 * @author Mehraj Malik
 *
 */
@RestController
@RequestMapping("/api/")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Person>> searchAll(){
		System.out.println("---- searchAll ----");
		return personService.getAllPerson()
						.map((personList)->new ResponseEntity<>(personList,HttpStatus.FOUND))
						.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	

	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Person person){
		System.out.println("--- save ----");
		return personService.savePerson(person)
					.map((status)->new ResponseEntity<>("Saved successfully", HttpStatus.OK))
					.orElse(new ResponseEntity<>("Save Failed",HttpStatus.INTERNAL_SERVER_ERROR));
		
	}
}
