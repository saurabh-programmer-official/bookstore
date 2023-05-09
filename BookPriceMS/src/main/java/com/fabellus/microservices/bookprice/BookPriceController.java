package com.fabellus.microservices.bookprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiOperation;

//Applying Hysterix
@CrossOrigin
@RestController
public class BookPriceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${server.port}")
	String bookPriceServerPort;
	
	@Autowired
	BookPriceService bookPriceService;


	@GetMapping("/bookPrice/{bookId}")
	@HystrixCommand(fallbackMethod = "getBookPriceInfofallBack")
	public BookPriceInfo geBookPriceInfo(@PathVariable int bookId)
	{
		logger.info("BookPriceController--getBookPrice()--");
		/*
		 * BookPriceInfo bookPriceInfo = new BookPriceInfo(bookId, 5000,10.0,bookPriceServerPort);
		
		
		logger.info(bookPriceServerPort.toString());
		return bookPriceInfo;
		*/
		
		if(1==1) {
			try {
				throw new BookPriceException();
			}catch(BookPriceException ex) {
				ex.printStackTrace();
			}
		}
		return null;

		//		return bookPriceService.getBookPriceInfo(bookId);
	}
	
	@GetMapping("/offeredPrice/{bookId}")
	@HystrixCommand(fallbackMethod = "getOfferedPriceFallBack")
	public double getOfferedPrice(@PathVariable int bookId) {
		logger.info("--BookPriceController--getOfferedPrice()--");
/*		double offeredPrice = bookPriceService.getOfferPrice(bookId);
		logger.info("offeredPrice: " +offeredPrice);
		return offeredPrice;
*/
		if(1==1) {
			try {
				throw new BookPriceException();
			}catch(BookPriceException ex) {
				ex.printStackTrace();
			}
		}
		return 0;
		}
	
	
	public BookPriceInfo getBookPriceInfofallBack(int bookId) {
		logger.info("--BookPriceController getBookPriceInfoFallBack()--");
			return bookPriceService.getBookPriceInfo(bookId);		
	}
	
	public double getOfferedPriceFallBack(int bookId) {
		logger.info("--BookPricController getBookPriceFallBack()--");
		double offeredPrice = bookPriceService.getOfferPrice(bookId);
		logger.info("offeredPrice: " +offeredPrice);
		return offeredPrice;
	}
}
