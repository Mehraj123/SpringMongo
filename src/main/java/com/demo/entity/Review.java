package com.demo.entity;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class Review {

	private int rating;
	private String description;
	private User user;
	private boolean isApproved;
	
	public Review(){}

	public Review(int rating, String description, User user, boolean isApproved) {
		this.rating = rating;
		this.description = description;
		this.user = user;
		this.isApproved = isApproved;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
