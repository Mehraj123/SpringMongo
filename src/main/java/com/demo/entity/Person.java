package com.demo.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Mehraj Malik
 * <p> Mongo collection for Person
 */
@Document(collection="Person")
public class Person {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	private String startDate;
	private String endDate;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, String startDate, String endDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Person [ "+
				"Id : "+Objects.toString(id)+","+
				"firstName :"+Objects.toString(firstName,"First Name is null")+","+
				"lastName :"+Objects.toString(lastName, "Last Name is null")+","+
				"startDate : "+Objects.toString(startDate,"Start date is null")+","+
				"endDate : "+Objects.toString(endDate,"End Date is null")+"]";
	}

}
