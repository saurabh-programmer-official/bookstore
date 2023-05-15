package com.fabellus.booksearch;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="MyBookPriceMS", url ="http://localhost:3001")
public interface BookPriceProxy {


	@GetMapping("/bookPrice/{bookId}")
	public BookPriceInfo getBookPriceInfo(@PathVariable("bookId") int bookId);
	
	@GetMapping("/offeredPrice/{bookId}")
	public double getOfferedPrice(@PathVariable("bookId") int bookId);
}