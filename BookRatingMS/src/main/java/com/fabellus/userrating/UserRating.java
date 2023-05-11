package com.fabellus.userrating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="myuserratings",schema = "jlcratingsdb")
public class UserRating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rating_gen")
	@SequenceGenerator(schema = "jlcratingsdb",allocationSize = 1,initialValue = 8, sequenceName = "rating_id_gen",name = "rating_gen")
	@Column(name="rating_id")
	int ratingId;
	
	@Column(name="book_id")
	int bookId;
	
	@Column(name="user_id")
	String userId;
	
	@Column(name="rating")
	double rating;
	
	@Column(name="review")
	String review;


	public UserRating(int bookId, String userId, double rating, String review) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}

	public UserRating() {
		super();
	}

	public UserRating(int ratingId, int bookId, String userId, double rating, String review) {
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