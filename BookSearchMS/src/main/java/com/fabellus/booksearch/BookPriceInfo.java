package com.fabellus.booksearch;

import org.springframework.stereotype.Component;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel("PriceInfo object which contains BookId, price and offer/discount") 
@Component("com")
public class BookPriceInfo {


	private int bookId;
	
//	@ApiModelProperty("holds price") 
	private double price;
	
//	@ApiModelProperty("holds offer") 
	private double offer;
	

	public BookPriceInfo(int bookId, double price, double offer) {
//		super();
		this.bookId = bookId;
		this.price = price;
		this.offer = offer;
	}

	public BookPriceInfo(double price, double offer) {
		super();
		this.price = price;
		this.offer = offer;
	}

	public BookPriceInfo() {
		super();
	}
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "BookPriceInfo [bookId=" + bookId + ", price=" + price + ", offer=" + offer + ", bookPriceServerPort="
				 + "]";
	}
	
	
}
