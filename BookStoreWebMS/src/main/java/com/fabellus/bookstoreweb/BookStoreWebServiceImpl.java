package com.fabellus.bookstoreweb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fabellus.rabbitmq.OrderFullInfoRabbit;
import com.fabellus.rabbitmq.OrderItemRabbit;
import com.fabellus.rabbitmq.OrderRabbit;
import com.fabellus.rabbitmq.UserRatingInfo;


@Service
@Transactional
public class BookStoreWebServiceImpl implements BookStoreWebService{
	static Logger log = LoggerFactory.getLogger(BookStoreWebServiceImpl.class);
	
	@Autowired
	RabbitTemplate rabbitTemplate;

	Map<Integer,Book> booksMap = new LinkedHashMap<>();
	

	@Override
	public void addUserRating(UserRating userRating) {
	//Add UserRating 
	//TODO Auto-generated method stub
	System.out.println("BookServiceImpl: adduserrating: "+ userRating);

	//Step1. Serialize userrating into userratinginfo object that can be passed as message using rabbittemplate object
	UserRatingInfo userRatingInfo = new UserRatingInfo(userRating.getRatingId(),userRating.getBookId(),userRating.getUserId(),userRating.getRating(),userRating.getReview());
	rabbitTemplate.convertAndSend("myuserratings.queue", userRatingInfo);
	/*	 RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:5000/addUserRating";
	restTemplate.postForObject(url, userRating, void.class);
	*/
	
}
@Override
public List<String> getAuthorList() {
	// TODO Auto-generated method stub
	List<String> authorList = new ArrayList<>();
	authorList.add("All Authors");
	authorList.add("Srinivas Dande");
	authorList.add("Saurabh B");
	authorList.add("Radhika B");
	return authorList;
}
@Override
public List<Book> getAllBooks() {
	// TODO Auto-generated method stub
	RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:7000/mybooks";

	List<Book> bookList = restTemplate.getForObject(url, List.class);
//	List<Book> bookList = bookSearchProxy.getAllBooks();

	return bookList;
}
@Override
public List<String> getCategoryList() {
	// TODO Auto-generated method stub
	List<String> catList=new ArrayList<>(); 
	catList.add("All Categories"); 
	catList.add("Web"); 
	catList.add("Spring"); 
	catList.add("Server");
	catList.add("Database");
	catList.add("Finance");
	catList.add("Marketing");
	return catList; 
}
@Override
public Book getBookByBookId(int bookId) {
	// TODO Auto-generated method stub
	log.info("--BookStoreWebServiceImpl getBookByBookId--");
	RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:7000/mybookOnly/"+bookId;
	Book book = restTemplate.getForObject(url, Book.class);
	log.info("--BookStoreWebServiceImpl getBookByBookId--"+ book);
	return book; 
}

@Override
public BookInfo getBookInfoByBookId(int bookId) {
	// TODO Auto-generated method stub
	System.out.println("Book Info in service IMPL");
	RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:7000/mybookInfo/"+bookId;
	BookInfo book=  restTemplate.getForObject(url,BookInfo.class);

	return book;
}
	 
@Override
public List<Book> getMyBook(String author, String category) {
	// TODO Auto-generated method stub
	log.info("BookStoreWebServiceImpl--getMyBook--");
	if(author==null || author.length()==0){
		author="All Authors";
	}
	if(category==null|| category.length()==0) {
		category="All Categories";
	}
	//Using RestTemplate to invoke BookSearch API Rest end points
 
  	RestTemplate restTemplate = new RestTemplate();
	
	String url ="http://localhost:7000/mybooks/author/"+author+"/category/"+category;
	log.info("categoey: "+category);
	List<Book> bookList = restTemplate.getForObject(url, List.class);  
	
	return  bookList;
}

@Override
public List<Order> getMyOrders(String userId) {
	// TODO Auto-generated method stub
	RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:6002/myorders/"+userId;
	return restTemplate.getForObject(url, List.class);
}

@Override
public List<UserRating> getMyRatings(String userId) {
	// TODO Auto-generated method stub
// 	Invoking UserRatingMS using Rest Template
  	RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:5000/getUserRatings/"+userId;
	return restTemplate.getForObject(url, List.class);

}

@Override
public OrderInfo placeOrder(Map<Integer,Book> myCartMap){
	// TODO Auto-generated method stub
	List<OrderItem> orderItems = new ArrayList<>();
	int totalQuantity = 0;
	double totalCost = 0;
	
	// Taking Collection from Map using values() method
	Collection<Book> books = myCartMap.values();
	for(Book book:books){
		System.out.println("Placeorder in BookStore IMPL"+book);
		Integer bookId = book.getBookId();
		
// 		fetching  by invoking BookPrice REST API using REST Template
  		RestTemplate bookPriceRest = new RestTemplate();
		
		//Rest call to fetch price
		String priceEndPoint = "http://localhost:3002/offeredPrice/"+bookId;
		double offerPrice = bookPriceRest.getForObject(priceEndPoint, double.class);
		totalCost=offerPrice+totalCost;
		OrderItem orderItem = new OrderItem(0,bookId,1,offerPrice);
		orderItems.add(orderItem);
		totalQuantity = totalQuantity+1;
		
	}
	System.out.println("Offer price Placeorder in BookStore IMPL"+totalCost);
	
	Date today = Calendar.getInstance().getTime(); 
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm"); 
	String orderDate = formatter.format(today); 
	System.out.println(orderDate); 
	Order order = new Order(orderDate,"U-111",totalQuantity,totalCost,"New");
	
	OrderInfo orderInfo = new OrderInfo(); 
	orderInfo.setOrder(order); 
	orderInfo.setItemList(orderItems); 
	System.out.println("Order info(Order+OrderItem: "+ order + " : "+orderInfo);
	
	
	System.out.println("Order Place Successfully");

	//PlaceHolder MS called using RabbitMQ
	//Step 1. Convert POJO to RabbitMQ object, OrderRabbit and OrderItemRabbit
	OrderRabbit orderRabbit = new OrderRabbit(order.getOrderId(),order.getOrderDate(),order.getUserId(),order.getTotalQty(),order.getTotalCost(),order.getStatus());
	List<OrderItemRabbit> orderItemRabbitList = new ArrayList<>();
	for(OrderItem orderItem:orderItems) {
		OrderItemRabbit orderItemRabbit = new OrderItemRabbit(order.getOrderId(),orderItem.getBookId(),orderItem.getQty(),orderItem.getCost());
		orderItemRabbitList.add(orderItemRabbit);
	}
	OrderFullInfoRabbit orderFullInfoRabbit = new OrderFullInfoRabbit(orderRabbit,orderItemRabbitList);
	rabbitTemplate.convertAndSend("myorder.queue", orderFullInfoRabbit);
	return orderInfo;		
	}	/*
	//PlaceOrder MicroService Called using RestTemplate
	RestTemplate placeOrderRest = new RestTemplate();
	String priceEndPoint = "http://localhost:6002/placeorder";
	orderInfo=placeOrderRest.postForObject(priceEndPoint,orderInfo, OrderInfo.class);
	System.out.println("Order Place Successfully");

	List<OrderItem>orderItemList = orderInfo.getItemList();
	for(OrderItem orderItem:orderItemList) {
		int bookId = orderItem.getBookId();
		RestTemplate bookPriceRest = new RestTemplate();
		String priceUrl = "http://localhost:3002/offeredPrice/"+bookId;
		double offerPrice = bookPriceRest.getForObject(priceUrl, double.class);
	}
	RestTemplate restTemplate = new RestTemplate();
	//String url ="http://localhost:6002/
	*/

}

