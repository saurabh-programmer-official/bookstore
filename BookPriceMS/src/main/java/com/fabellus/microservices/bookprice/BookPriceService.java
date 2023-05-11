package com.fabellus.microservices.bookprice;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookPriceService {

	public BookPriceInfo getBookPriceInfo(int bookid);
	public double getOfferPrice(int bookid);
}
