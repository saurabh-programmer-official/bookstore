package com.fabellus.rabbitmq;

import java.io.Serializable;

public class BookInventoryInfo implements Serializable{

	private int bookId;
	
	private int bookAvailable;

	public BookInventoryInfo() {
		super();
	}
	public BookInventoryInfo(int bookId, int bookAvailable) {
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
