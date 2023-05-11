package com.fabellus.userrating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="mybookrating")
//@ApiModel("BookRating contains bookId, avgRating and number of searches")
public class BookRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
	@SequenceGenerator(name="rating_generator",sequenceName = "ratingId_generator",allocationSize= 1, initialValue = 109)
	@Column(name="book_id")
//	@ApiModelProperty("Hold the book id")
	private int bookId;

	@Column(name="avg_rating")
	private double rating;
	
	@Column(name="number_of_searches")
	private int number_of_searches;

	public BookRating() {
		super();
	}

	public BookRating(int bookId, double rating, int number_of_searches) {
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

	@Override
	public String toString() {
		return "BookRating [bookId=" + bookId + ", rating=" + rating + ", number_of_searches=" + number_of_searches
				+ "]";
	}
	

}
