package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.demo.entity.Hotel;
import com.demo.exception.CustomExceptionCode;
import com.demo.exception.CustomParameterizedException;
import com.demo.repository.HotelRepository;
import com.demo.service.HotelService;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Optional<List<Hotel>> findByRatingGTE(int rating) {
		try {
			List<Hotel> hotels = hotelRepository.findByRatingGTE(rating);
			return Optional.ofNullable(hotels);
		} catch (Exception e) {
			logger.error(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg());
			throw new CustomParameterizedException(CustomExceptionCode.DB_DELETE_ERROR.getErrMsg(),
					CustomExceptionCode.DB_DELETE_ERROR.getErrCode());
		}
	}


	
	/*@Override
	public Optional<List<Hotel>> customMethod() {
		try {
			List<Hotel> hotels = hotelRepository.findAllName();
			return Optional.ofNullable(hotels);
		} catch (Exception e) {
			logger.error(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg());
			throw new CustomParameterizedException(CustomExceptionCode.DB_DELETE_ERROR.getErrMsg(),
					CustomExceptionCode.DB_DELETE_ERROR.getErrCode());
		}
	}*/

}
