package com.fabellus.booksearch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{

	public List<Book> getBooksByAuthorAndCategory(String author, String category);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByCategory(String category);
	
	
}
