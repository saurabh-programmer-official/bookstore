package com.fabellus.booksearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
@Transactional
public class BookSearchServiceImpl implements BookSearchService{

	@Autowired
	BookSearchDAO bookSearchDAO;
	@Autowired
	BookRatingDAO bookRatingDAO;
	@Autowired
	BookInventoryDAO bookInventoryDAO;
	
 public Book getBookByBookId(int bookId) {
 		// TODO Auto-generated method stub
 		return bookSearchDAO.findById(bookId).get();
 	}	
	public List<Book> findBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> myList = new ArrayList();
		myList = bookSearchDAO.getBooksByCategory(category);
		return myList;
	}
	
	public List<Book> getBooksByAuthor(String author) {
	// TODO Auto-generated method stub
	List<Book> myList = new ArrayList();
	myList = bookSearchDAO.getBooksByAuthor(author);
	return myList;
	}
	public List<Book> getBooksByAuthorAndCategory(String author, String category) {
		// TODO Auto-generated method stub
		List <Book> myList = new ArrayList();
	//	String author1 = null;
		//String category1 = null;
		if(author.equals("All Authors")&& category.equals("All Categories"))
			myList = bookSearchDAO.findAll();
		else if(author.equals("All Authors")&& !category.equals("All Categories")){
				myList = bookSearchDAO.getBooksByCategory(category);}
		else if(!author.equals("All Authors")&& category.equals("All Categories")){
			myList = bookSearchDAO.getBooksByAuthor(author);
			}
		else if(!author.equals("All Authors")&& !category.equals("All Categories"))
			myList = bookSearchDAO.getBooksByAuthorAndCategory(author, category);
		
	return myList;
	}
	public BookInfo getBookInfoById(int bookId) {
		// TODO Auto-generated method stub
		System.out.println("BookSearchServiceIMPL -");
		BookInfo bookInfo = new BookInfo();
		Book book = new Book();
		book = bookSearchDAO.findById(bookId).get();
		bookInfo.setBookId(book.getBookId());
		bookInfo.setBookName(book.getBookName());
		bookInfo.setAuthor(book.getAuthor());
		bookInfo.setPublication(book.getPublication());
		bookInfo.setCategory(book.getCategory());
		BookRating bookRating = new BookRating();
		bookRating = bookRatingDAO.findById(bookId).get();
		bookInfo.setRating(bookRating.getRating());
		bookInfo.setNumber_of_searches(bookRating.getNumber_of_searches());
		BookInventory bookInventory = new BookInventory();
		bookInventory = bookInventoryDAO.findById(bookId).get();
		bookInfo.setInventory(bookInventory.getBookAvailable());
		System.out.println("BookSearchServiceIMPL -2 , Book INfo Object+" +bookInfo);
		
		//Book Price Info using RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:3002/bookPrice/"+bookId;
		BookPriceInfo bpf = restTemplate.getForObject(url, BookPriceInfo.class);
		bookInfo.setPrice(bpf.getPrice());
		bookInfo.setOffer(bpf.getOffer());
		System.out.println("BookSearchServiceIMPL - 3, Book INfo"+ bookInfo);
		return bookInfo;
	}
	
	public void updateBookInventory(BookInventory bookInventory ) {
		

		//Update Local Book Inventory
		bookInventoryDAO.save(bookInventory);
		
		//Remote Book Inventory updates

		}
	
	public void updateBookRating(BookRating bookRatingInfo) {
		BookRating bookRating = new BookRating(bookRatingInfo.getBookId(),bookRatingInfo.getRating(),bookRatingInfo.getNumber_of_searches());
		bookRatingDAO.save(bookRating);
	}
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		System.out.println("BookSearchIMPL serviceIMPL getallboooks()");
		return bookSearchDAO.findAll();
	}
}