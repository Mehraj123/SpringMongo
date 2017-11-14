package com.demo.repository.custom.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entity.Hotel;
import com.demo.entity.UnwindHotel;
import com.demo.exception.CustomExceptionCode;
import com.demo.exception.CustomParameterizedException;
import com.demo.repository.custom.HotelCustomRepository;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class HotelRepositoryImpl implements HotelCustomRepository {

	private static final Logger logger = LoggerFactory.getLogger(HotelRepositoryImpl.class);

	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * Aggregation : Spring Data MongoDB provides an abstraction for native
	 * aggregation queries using the three classes Aggregation which wraps an
	 * aggregation query, AggregationOperation which wraps individual pipeline
	 * stages and AggregationResults which is the container of the result produced
	 * by aggregation.
	 * 
	 * To perform and aggregation, first, create aggregation pipelines using the
	 * static builder methods on Aggregation class, then create an instance of
	 * Aggregation using the newAggregation() method on the Aggregation class and
	 * finally run the aggregation using MongoTemplate:
	 */

	@Override
	public Optional<List<UnwindHotel>> customMethod() {
		try {
			UnwindOperation unwindOperation = Aggregation.unwind("reviews");
			ProjectionOperation projectionOperation = Aggregation.project("name", "reviews");
			MatchOperation matchOperation = Aggregation.match(Criteria.where("reviews.rating").gte(7));
			//GroupOperation groupOperation = Aggregation.group("name").count().as("count");
			//SortOperation sortOperation = Aggregation.sort(new Sort(Direction.DESC, "count"));
			Aggregation aggregation = Aggregation.newAggregation(unwindOperation, matchOperation, projectionOperation);
			AggregationResults<UnwindHotel> results = mongoOperations.aggregate(aggregation, "hotel",
					UnwindHotel.class);
			return Optional.ofNullable(results.getMappedResults());
		} catch (Exception e) {
			logger.error(" Exception : " + e.toString());
			throw new CustomParameterizedException(CustomExceptionCode.DB_DELETE_ERROR.getErrMsg(),
					CustomExceptionCode.DB_DELETE_ERROR.getErrCode());
		}
	}

	/*
	 * @Override public List<Hotel> findByRatingGTE(int rating) { Query
	 * findByRatingGTE = new Query(Criteria.where("reviews.rating").gte(rating));
	 * findByRatingGTE.fields().include("reviews.$");
	 * findByRatingGTE.fields().include("name");
	 * findByRatingGTE.fields().include("pricePerNight");
	 * findByRatingGTE.fields().include("address");
	 * 
	 * List<Hotel> hotels = mongoOperations.find(findByRatingGTE, Hotel.class);
	 * return hotels; }
	 */

	@Override
	public List<Hotel> findByRatingGTE(int rating) {
		Query findByRatingGTE = new Query(Criteria.where("reviews.rating").gte(rating));
		findByRatingGTE.fields().include("reviews.$");
		findByRatingGTE.fields().include("name");
		findByRatingGTE.fields().include("pricePerNight");
		findByRatingGTE.fields().include("address");

		List<Hotel> hotels = mongoOperations.find(findByRatingGTE, Hotel.class);
		return hotels;
	}

	@Override
	public List<Hotel> getAllCountries() {
		
		
		 ProjectionOperation projection = Aggregation.project("address");
		 Aggregation aggregation = Aggregation.newAggregation(projection);
		AggregationResults<Hotel> results = mongoOperations.aggregate(aggregation, "hotel", Hotel.class);
		List<Hotel> list =  results.getMappedResults();
		logger.info("--- Total countries : "+list.size());
		return list;
	}

}
