package com.fabellus.bookstoreweb;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="MyBookSearchMS", url="http://localhost:7000")
public interface BookSearchProxy {
	
	@GetMapping("/mybook/{bookId}")
	public BookInfo getBookInfoById(@PathVariable int bookId);
	
	@GetMapping("/mybooks/author/{author}/category/{category}")
	public List<Book> getBooksByAuthorAndCategory(@PathVariable String author, @PathVariable String category);

	@GetMapping("/mybooks")
	public List<Book> getAllBooks();
	
}