package com.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Hotel;
import com.demo.repository.custom.HotelCustomRepository;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, HotelCustomRepository{

	/**
	 * value="{}" will fetch all the document
	 * fields="{name:1,_id:0}" will include only name field
	 * 
	 *//*
	@Query(value="{}", fields="{name:1,_id:0}")
	public List<Hotel> findAllName();*/
	
	@Query(value="{}", fields="{name:1,_id:0}")
	public List<Hotel> findAllName();
}
