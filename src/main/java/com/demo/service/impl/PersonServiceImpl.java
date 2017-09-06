package com.demo.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Person;
import com.demo.exception.CustomExceptionCode;
import com.demo.exception.CustomParameterizedException;
import com.demo.model.PersonVM;
import com.demo.repository.PersonRepository;
import com.demo.service.PersonService;
import com.demo.util.DateConverter;
import static com.demo.util.ExceptionSupplierFactory.*;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Optional<Person> getPersonById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Person>> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Optional<Person>> getByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author Mehraj Malik
	 */
	@Override
	public Optional<Boolean> savePerson(PersonVM personModel) {
		logger.info("---- savePerson service called ---");
		try {
			Person person = new Person();
			person.setFirstName(personModel.getFirstName());
			person.setLastName(personModel.getLastName());
			person.setStartDate(DateConverter.validateDateTime(personModel.getStartDate()));
			person.setEndDate(DateConverter.validateDateTime(personModel.getEndDate()));
			personRepository.save(person);
			return Optional.ofNullable(Boolean.TRUE);
		} catch (ParseException e) {
			logger.error(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg());
			throw new CustomParameterizedException(CustomExceptionCode.DATE_PARSE_EXCEPTION.getErrMsg(),
					CustomExceptionCode.DATE_PARSE_EXCEPTION.getErrCode());
		} catch (Exception e) {
			logger.error(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg());
			throw dbFetchError().get();
		}
	}

	@Override
	public Optional<Boolean> updatePersonById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author Mehraj Malik
	 */
	@Override
	public Optional<List<Person>> getAllPerson() {
		logger.info("--- getAllPerson service called ---");
		try {
			List<Person> persons = personRepository.findAll();
			return Optional.ofNullable(persons);
		} catch (Exception e) {
			logger.error(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg());
			throw dbFetchError().get();
		}
	}

}
