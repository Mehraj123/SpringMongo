package com.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Person;


/**
 * 
 * @author Mehraj Malik
 * <p> Mongo Repository for Person</p>
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

}
