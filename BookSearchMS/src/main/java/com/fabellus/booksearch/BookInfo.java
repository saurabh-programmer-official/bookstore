package com.fabellus.booksearch;

//Simple POJO
public class BookInfo {
	public BookInfo(int bookId, String bookName, String author, String publication, String category, double rating,
			int number_of_searches, int inventory, double price, double offer, String serverPort,
			String bookSearchServerPort, String bookPriceServerPort) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.rating = rating;
		this.number_of_searches = number_of_searches;
		this.inventory = inventory;
		this.price = price;
		this.offer = offer;
		this.serverPort = serverPort;
		this.bookSearchServerPort = bookSearchServerPort;
		this.bookPriceServerPort = bookPriceServerPort;
	}
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
	private String serverPort;
	private String bookSearchServerPort;
	private String bookPriceServerPort;
	

	public String getServerPort() {
		return serverPort;
	}


	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}


	public BookInfo(int bookId, String bookName, String author, String publication, String category, double rating,
			int number_of_searches, int inventory, double price, double offer, String serverPort) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.rating = rating;
		this.number_of_searches = number_of_searches;
		this.inventory = inventory;
		this.price = price;
		this.offer = offer;
		this.serverPort = serverPort;
	}

	
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
				+ number_of_searches + ", inventory=" + inventory + ", price=" + price + ", offer=" + offer
				+ ", serverPort=" + serverPort + "]";
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


	public String getBookSearchServerPort() {
		return bookSearchServerPort;
	}


	public void setBookSearchServerPort(String bookSearchServerPort) {
		this.bookSearchServerPort = bookSearchServerPort;
	}


	public String getBookPriceServerPort() {
		return bookPriceServerPort;
	}


	public void setBookPriceServerPort(String bookPriceServerPort) {
		this.bookPriceServerPort = bookPriceServerPort;
	}
	
}