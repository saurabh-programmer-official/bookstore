package com.fabellus.microservices.bookprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
public class BookPriceController {

	static Logger logger = LoggerFactory.getLogger(BookPriceController.class);
	
	@Value("${server.port}")
	String bookPriceServerPort;
	
	@Autowired
	BookPriceService bookPriceService;


	@GetMapping("/mybooks/{bookId}")
	@ApiOperation(value = "getBookPriceInfo", response=BookPriceInfo.class, notes = "Returns the Book PriceInfo object cosisting of price, discount")
	public BookPriceInfo geBookPriceInfo(@PathVariable int bookId)
	{
					return bookPriceService.getBookPriceInfo(bookId);
	}
	
	@GetMapping("/offeredPrice/{bookId}")
	@ApiOperation(value = "getOfferedPrice", response=double.class, notes = "Returns the Offered Price")
	public double getOfferedPrice(@PathVariable int bookId) {
		logger.info("--BookPriceController--getOfferedPrice()--");
		double offeredPrice = bookPriceService.getOfferPrice(bookId);
		logger.info("offeredPrice: " +offeredPrice);
		return offeredPrice;
		}	
}