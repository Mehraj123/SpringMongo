package com.demo.controller;

import static com.demo.util.FunctionFactory.biFunction;
import static com.demo.util.FunctionFactory.boolBiFunction;
import static com.demo.util.SuccessCode.FETCHED_SUCCESSFULLY;
import static com.demo.util.SuccessCode.SAVED_SUCCESSFULLY;
import static com.demo.util.SupplierFactory.emptyRespone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.PersonVM;
import com.demo.service.PersonService;
import com.demo.util.CustomeResponse;

/**
 * 
 * @author Mehraj Malik
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonService personService;

	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@GetMapping
	public ResponseEntity<CustomeResponse> searchAll() {
		return personService.getAllPerson()
				.map((persons) ->biFunction.apply(FETCHED_SUCCESSFULLY.getCode(),persons) )
				.orElse(emptyRespone().get());
	}

	/**
	 * @author Mehraj Malik
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CustomeResponse> save(@RequestBody PersonVM person) {
		return personService.savePerson(person)
				.map((status) -> boolBiFunction.apply(SAVED_SUCCESSFULLY.getCode(),status))
				.orElse(emptyRespone().get());

	}
}
