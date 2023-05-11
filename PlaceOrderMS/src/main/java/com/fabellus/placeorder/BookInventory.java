package com.fabellus.placeorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="mybookinventory",schema = "jlcorderdb")
public class BookInventory {

	public BookInventory(int bookAvailable) {
		super();
		this.bookAvailable = bookAvailable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookInventory_gen")
	@SequenceGenerator(name = "bookInventory_gen",schema = "jlcorderdb",allocationSize = 1,initialValue = 111,sequenceName = "bookInv_Id_gen" )
//	@ApiModelProperty("Holds the book Id")
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="books_available")
//	@ApiModelProperty("holds the number of books avlble")
	private int bookAvailable;

	public BookInventory() {
		super();
	}
	public BookInventory(int bookId, int bookAvailable) {
		super();
		this.bookId = bookId;
		this.bookAvailable = bookAvailable;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookAvailable() {
		return bookAvailable;
	}

	public void setBookAvailable(int bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

	@Override
	public String toString() {
		return "BookInventory [bookId=" + bookId + ", bookAvailable=" + bookAvailable + "]";
	}
	
	
}
