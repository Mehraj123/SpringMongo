package com.demo.entity;


public class UnwindHotel {

	private String id;
	private String name;
	private int count;
	private int pricePerNight;
	private Address address;
	private Review reviews;
	public UnwindHotel() {
		super();
	}
	public UnwindHotel(String id,String name, int pricePerNight, Address address, Review reviews,int count) {
		super();
		this.id=id;
		this.name = name;
		this.count=count;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Review getReviews() {
		return reviews;
	}
	public void setReviews(Review reviews) {
		this.reviews = reviews;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
