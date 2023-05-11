
package com.fabellus.booksearch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class BookSearchController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Value("${server.port}")
	String bookSearchServerPort;
	
	@Autowired
	BookSearchService bookSearchService;
	
	@GetMapping("/mybookInfo/{bookId}")
	@ApiOperation(value = "getBookInfo", response=BookInfo.class, notes = "Returns the Book Info object cosisting of all elements")
	public BookInfo getBookInfo(@PathVariable int bookId){

		log.info("--BookSearchController--getBookInfo--");
		BookInfo bookInfo = bookSearchService.getBookInfoById(bookId);
		
		return bookInfo;
		
	}
	
	@GetMapping("/mybookOnly/{bookId}")
	@ApiOperation(value="getBook", response = Book.class, notes="returns the book details")
	public Book getBook(@PathVariable int bookId) {
		log.info("Book Controllers--getBook--");
		Book book = bookSearchService.getBookByBookId(bookId);
		log.info("Book Controllers--getBook--" +book);
		return book;
	}
	
	@GetMapping("/mybooks/author/{author}/category/{category}")
	@ApiOperation(value = "getBookInfoByAUthor", response=List.class, notes = "Returns the BookInfo object by Author filter")
	public List<Book> getBooksByAuthor(@PathVariable String author,@PathVariable String category){
		log.info("--BookSearchController--getBooksByAuthor--");
			return bookSearchService.getBooksByAuthorAndCategory(author, category);
	}

	@GetMapping("/mybooks/{author}")
	@ApiOperation(value = "getBookInfoByAUthor", response=List.class, notes = "Returns the BookInfo object by Author filter")
	public List<Book> getBooksByAuthor(@PathVariable String author){
		log.info("--BookSearchController--getBooksByAuthor--");
			return bookSearchService.getBooksByAuthor(author);
		
	}
	@GetMapping("/mybooks")
	@ApiOperation(value="getAllBooks()",notes = "Returns all books")
	public List<Book> getAllBooks(){
		System.out.println("BookSearchController getAllBooks");
		return bookSearchService.getAllBooks();
	}
	
}
