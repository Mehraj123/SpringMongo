package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.entity.Person;

/**
 * 
 * @author Mehraj Malik
 *
 */
public interface PersonService {

	public Optional<Person> getPersonById(String id);
	public Optional<List<Person>> getByFirstName(String firstName);
	public List<Optional<Person>> getByLastName(String lastName);
	public Optional<Boolean> savePerson(Person person);
	public Optional<Boolean> updatePersonById(String id);
	public Optional<List<Person>> getAllPerson();
}
