package com.fabellus.bookstoreweb;


//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel(value = "User rating DTO/POJO class")
public class UserRating {
	//@ApiModelProperty("Holds the rating id")
	int ratingId;
	

	//@ApiModelProperty("holds the book id")
	int bookId;
	

	//@ApiModelProperty("holds the user id")
	String userId;
	

	//@ApiModelProperty("holds the rating given by the user")
	double rating;
	

	//@ApiModelProperty("Holds the review")
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
