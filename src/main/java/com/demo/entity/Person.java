package com.demo.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
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
	private Date startDate;
	private LocalDate endDate;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, Date startDate, LocalDate endDate) {
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
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
