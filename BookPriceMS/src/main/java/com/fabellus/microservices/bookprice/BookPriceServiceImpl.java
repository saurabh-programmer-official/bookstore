package com.fabellus.microservices.bookprice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookPriceServiceImpl implements BookPriceService{
	static Logger log = LoggerFactory.getLogger(BookPriceServiceImpl.class);
	@Autowired
	BookPriceDAO bookPriceDAO;
@Override
public BookPriceInfo getBookPriceInfo(int bookid) {
	// TODO Auto-generated method stub
	log.info("--BookServiceImpl--getBookPriceInfobyId--");
	BookPriceInfo bookPriceInfo=null;
	Optional<BookPriceInfo> opt =bookPriceDAO.findById(bookid);
	if(opt.isPresent()) {
		bookPriceInfo = opt.get();
	} 
	return bookPriceInfo;
}
@Override
	public double getOfferPrice(int bookid) {
	log.info("--getOfferPrice--");
		// TODO Auto-generated method stub
	BookPriceInfo bookPriceInfo=null;
	Optional<BookPriceInfo> opt =bookPriceDAO.findById(bookid);
	if(opt.isPresent()) {
		bookPriceInfo = opt.get();
	}
	
	return bookPriceInfo.getPrice()*(1-bookPriceInfo.getOffer()/100); 
	}
}
