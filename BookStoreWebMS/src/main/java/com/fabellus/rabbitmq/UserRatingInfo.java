package com.fabellus.rabbitmq;

import java.io.Serializable;


public class UserRatingInfo implements Serializable{
	int ratingId;
	int bookId;
	String userId;
	double rating;
	String review;


	public UserRatingInfo(int bookId, String userId, double rating, String review) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}

	public UserRatingInfo() {
		super();
	}

	public UserRatingInfo(int ratingId, int bookId, String userId, double rating, String review) {
		super();
		this.ratingId = ratingId;
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}

		public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "UserRating [rating_id=" + ratingId + ", book_id=" + bookId + ", user_id=" + userId + ", rating="
				+ rating + ", review=" + review + "]";
	}
	
	
}
