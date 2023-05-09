package com.fabellus.bookstoreweb;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Only Using MicroService Name in this case
@FeignClient("MyApiGateWayServer")
public interface BookSearchProxy {
	@GetMapping("/my-book-price/mybooks/{bookid}")
	public BookPriceInfo getBookPriceObject(@PathVariable int bookid);
	
	
	@GetMapping("/my-book-price/offeredPrice/{bookid}")
	public double getBookOfferPrice(@PathVariable int bookid) ;
	@GetMapping("/my-book-search/mybooks/author/{author}/category/{category}")
	public List<Book> getBooksByAuthorAndCategory(@PathVariable String author, @PathVariable String category);

	@GetMapping("/my-book-search/mybooks")
	public List<Book> getAllBooks();
	
	@GetMapping("/my-book-search/mybookOnly/{bookId}")
	public Book getBookByBookId(@PathVariable int bookId);
	
	@GetMapping("/my-book-search/mybookInfo/{bookId}")
	public BookInfo getBookInfo(@PathVariable int bookId);

}
