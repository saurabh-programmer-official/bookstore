package com.fabellus.booksearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="mybook",schema = "jlcbooksearchdb")
@ApiModel("Book Contains bookId, BookName, Author, Publication, Category")
public class Book {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookId_generator")
	@SequenceGenerator(name = "bookId_generator",sequenceName ="mybookId_gen", initialValue = 106,
	allocationSize = 1)
	@Column(name="book_id")
	@ApiModelProperty("Holds BookId")
	 int bookId;
	
	@Column(name="book_name")
	@ApiModelProperty("Holds book name")
	 String bookName;
	
	@Column(name="author")
	@ApiModelProperty("Holds Author")
	 String author;
	
	@Column(name="publication")
	@ApiModelProperty("Holds publication name")
	String publication;
	
	@Column(name="category")
	@ApiModelProperty("Holds Category")
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
