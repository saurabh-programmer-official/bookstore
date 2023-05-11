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
@Table(name="mybookinventory",schema = "jlbooksearchdb")
@ApiModel("Book inventory contains")
public class BookInventory {

	public BookInventory(int bookAvailable) {
		super();
		this.bookAvailable = bookAvailable;
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "inventory_generator")
	@SequenceGenerator(name = "inventory_generator", schema = "jlcbooksearchdb",allocationSize = 1,initialValue = 111,sequenceName = "inv_gen")
	@Id
	@Column(name="book_id")
	@ApiModelProperty("Hold the book id")
	private int bookId;
	
	@Column(name="books_available")
	@ApiModelProperty("Holds the inventory")
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
		return "BookInventory [bookId=" + bookId + ", books_available=" + bookAvailable + "]";
	}
}
