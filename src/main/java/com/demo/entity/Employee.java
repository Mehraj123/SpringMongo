package com.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Mehraj Malik
 *
 */
@Document(collection="Employee")
public class Employee {

	@Id
	private String id;
	private String name;
	private List<Address> address;
	
	public Employee() {
	}

	
	
	public Employee(String name, List<Address> address) {
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
}
