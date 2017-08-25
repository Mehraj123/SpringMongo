package com.demo.model;

import java.time.LocalDateTime;

/**
 * 
 * @author Mehraj Malik
 * <p> Mongo collection for Person
 */
public class PersonVM {
	
	private String id;
	private String firstName;
	private String lastName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public PersonVM() {
	}
	
	public PersonVM(String firstName, String lastName, LocalDateTime startDate, LocalDateTime endDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
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
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	

}
