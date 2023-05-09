package com.fabellus.rabbitmq;

import java.io.Serializable;

import javax.persistence.Column;


public class BookRatingInfo implements Serializable	 {
	private int bookId;
	private double rating;
	private int number_of_searches;

	public BookRatingInfo() {
		super();
	}

	public BookRatingInfo(int bookId, double rating, int number_of_searches) {
		super();
		this.bookId = bookId;
		this.rating = rating;
		this.number_of_searches = number_of_searches;
	}

	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNumber_of_searches() {
		return number_of_searches;
	}

	public void setNumber_of_searches(int number_of_searches) {
		this.number_of_searches = number_of_searches;
	}
	

}
