package com.fabellus.booksearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fabellus.rabbitmq.BookInventoryInfo;
import com.fabellus.rabbitmq.BookRatingInfo;

//import com.fabellus.rabbitmq.BookInventoryInfo;
//import com.fabellus.rabbitmq.BookRatingInfo;

@Service
@Transactional
public class BookSearchServiceImpl implements BookSearchService{

	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	BookRatingDAO bookRatingDAO;
	
	@Autowired
	BookInventoryDAO bookInventoryDAO;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
 public Book getBookByBookId(int bookId) {
 		// TODO Auto-generated method stub
 		return bookDAO.findById(bookId).get();
 	}	
public List<Book> getBooks(String author, String category){
	
	List<Book> mybooks = new ArrayList();
	if(author.equals("All Authors") && category.equals("All Categories"))
		mybooks = bookDAO.findAll();
	else if(author.equals("All Authors")&& !category.equals("All Categories"))
		mybooks = bookDAO.getBooksByCategory(category);
	else if(!author.equals("All Authors")&& category.equals("All Categories"))
		mybooks = bookDAO.getBooksByAuthor(author);
	else
		mybooks = bookDAO.getBooksByAuthorAndCategory(author, category);
		
	return mybooks;
}
 public List<Book> findBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> myList = new ArrayList();
		myList = bookDAO.getBooksByCategory(category);
		return myList;
	}
	
public List<Book> getBooksByAuthor(String author) {
	// TODO Auto-generated method stub
	List<Book> myList = new ArrayList();
	myList = bookDAO.getBooksByAuthor(author);
	return myList;
	}
	
public List<Book> getBooksByAuthorAndCategory(String author, String category) {
		// TODO Auto-generated method stub
		System.out.println("--booksearchServiceImpl--getBooksByAuthorAndCategory--"+author+":"+category);
		List <Book> myList = new ArrayList();
	//	String author1 = null;
		//String category1 = null;
		if(author.equals("All Authors")&& category.equals("All Categories"))
			myList = bookDAO.findAll();
		else if(author.equals("All Authors")&& !category.equals("All Categories")){
				myList = bookDAO.getBooksByCategory(category);}
		else if(!author.equals("All Authors")&& category.equals("All Categories")){
			myList = bookDAO.getBooksByAuthor(author);
			}
		else if(!author.equals("All Authors")&& !category.equals("All Categories"))
			myList = bookDAO.getBooksByAuthorAndCategory(author, category);
		
	return myList;
	}
	
	public BookInfo getBookInfoById(int bookId) {
		// TODO Auto-generated method stub
		System.out.println("BookSearchServiceIMPL -");
		BookInfo bookInfo = new BookInfo();
		Book book = new Book();
		book = bookDAO.findById(bookId).get();
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
		String url = "http://localhost:3002/mybooks/"+bookId;
		BookPriceInfo bpf = restTemplate.getForObject(url, BookPriceInfo.class);
		
		bookInfo.setPrice(bpf.getPrice());
		bookInfo.setOffer(bpf.getOffer());

		System.out.println("BookSearchServiceIMPL - 3, Book INfo"+ bookInfo);
		return bookInfo;
	}
	
	@RabbitListener(queues= "myinventory.queue")
	public void updateBookInventory(BookInventoryInfo bookInventoryInfo ) {
		System.out.println("BookSerachMS serviceImpl methd called");
	
		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookAvailable(bookInventoryInfo.getBookAvailable());
		bookInventory.setBookId(bookInventoryInfo.getBookId());
		bookInventoryDAO.save(bookInventory);
		
		/*
		//Update Remote Inventory
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:6002/updateBookInventory";
		restTemplate.put(url, bookInventory);
		*/
	}
	
	@RabbitListener(queues="mybookratings.queue")
	public void updateBookRating(BookRatingInfo bookRatingInfo) {
		System.out.println("BookSearchImpl: bookRatingInfo: "+ bookRatingInfo.getBookId());
//		BookRating bookRating = new BookRating(bookRatingInfo.getBookId(),bookRatingInfo.getRating(),bookRatingInfo.getNumber_of_searches());
		BookRating bookRating = new BookRating();
		bookRating.setBookId(bookRatingInfo.getBookId());
		bookRating.setNumber_of_searches(bookRatingInfo.getNumber_of_searches());
		bookRating.setRating(bookRatingInfo.getRating());
		bookRatingDAO.save(bookRating);


		System.out.println("BookSearchImpl: bookRating: "+ bookRating);
		bookRatingDAO.save(bookRating);
	}
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		System.out.println("BookSearchIMPL serviceIMPL getallboooks()");
		return bookDAO.findAll();
	}
}
