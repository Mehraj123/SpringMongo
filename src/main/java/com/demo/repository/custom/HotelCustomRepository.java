package com.demo.repository.custom;

import java.util.List;
import java.util.Optional;

import com.demo.entity.Hotel;
import com.demo.entity.UnwindHotel;

/**
 * 
 * @author Mehraj Malik
 *
 */
public interface HotelCustomRepository {

	public List<Hotel> findByRatingGTE(int rating);

	public Optional<List<UnwindHotel>> customMethod();
	
	public List<Hotel> getAllCountries();
}
