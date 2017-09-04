package com.demo.model;


/**
 * 
 * @author Mehraj Malik
 */
public class PersonVM {
	
	private String id;
	private String firstName;
	private String lastName;
	private String startDate;
	private String endDate;
	
	public PersonVM() {
	}
	
	public PersonVM(String firstName, String lastName, String startDate, String endDate) {
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
	
	

}
