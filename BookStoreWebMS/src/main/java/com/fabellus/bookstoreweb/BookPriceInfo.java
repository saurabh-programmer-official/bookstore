package com.fabellus.bookstoreweb;

// Simple POJO Transfer Object TO
/*
 * This is  not an entity class and he ce we will strictly not use in persistence operations
 * */
public class BookPriceInfo {
	private int bookId;
	private double price;
	private double offer;

	public BookPriceInfo() {
		super();
	}
	public BookPriceInfo(int bookId, double price, double offer) {
		super();
		this.bookId = bookId;
		this.price = price;
		this.offer = offer;
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
}
