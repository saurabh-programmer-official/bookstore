package com.fabellus.bookstoreweb;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="mybookpriceMS",url = "http://localhost:3001")
public interface BookPriceProxy {

	
	@GetMapping("/bookPrice/{bookId}")
	public BookPriceInfo getBookPriceObject(@PathVariable int bookId);
	
	
	@GetMapping("/offeredPrice/{bookId}")
	public double getBookOfferPrice(@PathVariable int bookId) ;
	
}
