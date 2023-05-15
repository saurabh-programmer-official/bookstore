package com.fabellus.bookstoreweb;


public class Book {
	
//	@ApiModelProperty("Holds book id")
	 int bookId;
	
//	@ApiModelProperty("Holds book name")
	 String bookName;
	

//	@ApiModelProperty("Holds Author")
	 String author;
	

//	@ApiModelProperty("Holds publication name")
	String publication;
	

//	@ApiModelProperty("Holds Category")
	 String category;

	
	public Book(String bookName, String author, String publication, String category) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
	}
	public Book() {
		super();
	}
	public Book(int bookId, String bookName, String author, String publication, String category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
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
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publication="
				+ publication + ", category=" + category + "]";
	}
	
	
	
}
