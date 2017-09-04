package com.demo.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.PersonVM;
import com.demo.service.PersonService;
import com.demo.util.CustomeResponse;
import com.demo.util.FailedCode;
import com.demo.util.SuccessCode;

/**
 * 
 * @author Mehraj Malik
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonService personService;

	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@GetMapping
	public ResponseEntity<CustomeResponse> searchAll() {
		logger.info("--- searchAll ----");
		return personService.getAllPerson()
				.map((persons) -> new ResponseEntity<>(
						new CustomeResponse(SuccessCode.FETCHED_SUCCESSFULLY.getCode(), personService.getAllPerson().get()),
						HttpStatus.OK))
				.orElse(new ResponseEntity<CustomeResponse>(
						new CustomeResponse(FailedCode.FETCHED_FAILED.getCode(), Collections.emptyList()),
						HttpStatus.OK));
	}

	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CustomeResponse> save(@RequestBody PersonVM person) {
		logger.info("---- save ---");
		return personService.savePerson(person)
				.map((status) -> new ResponseEntity<>(
						new CustomeResponse(SuccessCode.SAVED_SUCCESSFULLY.getCode(), status.booleanValue()),
						HttpStatus.OK))
				.orElse(new ResponseEntity<CustomeResponse>(
						new CustomeResponse(FailedCode.SAVED_FAILED.getCode(), Collections.emptyList()),
						HttpStatus.OK));

	}
}
