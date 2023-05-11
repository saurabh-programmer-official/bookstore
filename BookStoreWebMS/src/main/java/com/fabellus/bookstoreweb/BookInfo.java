package com.fabellus.bookstoreweb;

//Simple POJO
public class BookInfo {

	private int bookId;
	private String bookName;
	private String author;
	private String publication;
	private String category;
	private double rating;
	private int number_of_searches;
	private int inventory;
	private double price;
	private double offer;

	
	public BookInfo() {
		super();
	}
	public BookInfo(int bookId, String bookName, String author, String publication, String category, double rating,
			int number_of_searches, int inventory) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.rating = rating;
		this.number_of_searches = number_of_searches;
		this.inventory = inventory;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publication="
				+ publication + ", category=" + category + ", rating=" + rating + ", number_of_searches="
				+ number_of_searches + ", inventory=" + inventory + "]";
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
