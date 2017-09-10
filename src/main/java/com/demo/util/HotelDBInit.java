package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Address;
import com.demo.entity.Hotel;
import com.demo.entity.Review;
import com.demo.entity.User;
import com.demo.repository.HotelRepository;

public class HotelDBInit implements CommandLineRunner{

	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel getHotels() {
		List<Review> godWin = new ArrayList<>();
		godWin.add(new Review(10, "The best hotel", new User("1", "IronMan"), true));
		godWin.add(new Review(9, "Just Awesome", new User("2", "SuperMan"), true));
		
		Hotel hotel = new Hotel(
				"God Win", 1000,
				new Address("India", "Meerut", "001") , 
				godWin
				);
		return hotel;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		hotelRepository.save(getHotels());	
		System.out.println("Hotel saved");
	}

}
