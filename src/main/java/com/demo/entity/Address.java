package com.demo.entity;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class Address {

	private String country;
	private String city;
	private String zipCode;

	
	public Address() {
	}

	public Address(String country, String city, String zipCode) {
		super();
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
}
