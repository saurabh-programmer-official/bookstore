package com.fabellus.booksearch;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface BookSearchService {
	public List<Book> getAllBooks();
	public List<Book> findBooksByCategory(String category);
	public List<Book> getBooksByAuthorAndCategory(String author,String category);	
	public List<Book> getBooksByAuthor(String author);
	public BookInfo getBookInfoById(int bookId);
	public void updateBookInventory(BookInventory bookInventory);
	
	public Book getBookByBookId(int bookId);
	public void updateBookRating(BookRating bookRating);
}