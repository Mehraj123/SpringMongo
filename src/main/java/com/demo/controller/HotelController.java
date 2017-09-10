package com.demo.controller;

import static com.demo.util.SuccessCode.FETCHED_SUCCESSFULLY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repository.HotelRepository;
import com.demo.service.HotelService;
import com.demo.util.CustomeResponse;
import com.demo.util.SupplierFactory;

/**
 * 
 * @author Mehraj Malik
 *
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HotelRepository hotelRepository;

	@GetMapping
	public ResponseEntity<CustomeResponse> searchAll() {

		return null;
	}

	@GetMapping("/rating/{rating}")
	public ResponseEntity<CustomeResponse> searchByRatingGTE(@PathVariable("rating") int rating) {
		return hotelRepository.customMethod()
				.map((hotels) -> new ResponseEntity<>(new CustomeResponse(FETCHED_SUCCESSFULLY.getCode(), hotels),
						HttpStatus.OK))
				.orElse(SupplierFactory.emptyRespone().get());
	}
}
