package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.entity.Hotel;

/**
 * 
 * @author Mehraj Malik
 *
 */
public interface HotelService {

	public Optional<List<Hotel>>  findByRatingGTE(int rating);
	//public Optional<List<Hotel>> customMethod();
}
