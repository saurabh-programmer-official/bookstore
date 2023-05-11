package com.fabellus.placeorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabellus.rabbitmq.BookInventoryInfo;
import com.fabellus.rabbitmq.OrderFullInfoRabbit;
import com.fabellus.rabbitmq.OrderItemRabbit;
import com.fabellus.rabbitmq.OrderRabbit;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;
	@Autowired
	private BookInventoryDAO bookInventoryDAO;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public List<Order> getOrdersByUserId(String userId) {
	// TODO Auto-generated method stub
	List<Order> orderList = orderDAO.findOrdersByUserId(userId);
		return orderList;

	}
	
	@RabbitListener(queues="myorder.queue")
	public void placeOrder(OrderFullInfoRabbit orderFullInfoRabbit) {
		// TODO Auto-generated method stub
		//Save the order
		//Order info is coming from front end and order is transient object for now
		OrderRabbit myorderRabbit = orderFullInfoRabbit.getOrder(); //Transient Object, Non Persistent Object without any primary key

		Order order = new Order(myorderRabbit.getOrderDate(),myorderRabbit.getUserId(),myorderRabbit.getTotalQty(),myorderRabbit.getTotalCost(),myorderRabbit.getStatus());
		order = orderDAO.save(order);//orderId Primary key gets generated
//		myorder = orderDAO.save(myorder); // Persistent Object with generated Primary Key
		int orderId = order.getOrderId(); //primarkey orderId post .save() operation
		
		//Insert Order Item Process
		
		//1. Get the Rabbit OrderItemsList
		List<OrderItemRabbit> orderItemListRabbit =orderFullInfoRabbit.getItemList();
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		
		//Iterating the orderItem List to deserialise and convert to POJO/Entity Object
		for(OrderItemRabbit orderItemRabbit: orderItemListRabbit) 
		{
			//Deserializing individual Rabbitmq object from the list and convert the rabbitmq object to either POJO/Entity
			OrderItem orderItem = new OrderItem(orderId,orderItemRabbit.getBookId(),orderItemRabbit.getQty(),orderItemRabbit.getCost());
		//orderItem.setOrderId(orderId);
			//Primary key will be generated of saved orderItem
		int orderItemId = orderItemDAO.save(orderItem).getOrderItemId();
		orderItemList.add(orderItem);
		
		}
		//Creating OrderInfo object
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrder(order);
		orderInfo.setItemList(orderItemList);
		
		// Update the local inventory
		for(OrderItem orderItem: orderItemList) {
			int bookId = orderItem.getBookId();
			BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
			bookInventory.setBookAvailable(bookInventory.getBookAvailable()-orderItem.getQty());
			bookInventory = bookInventoryDAO.save(bookInventory);
			
			//Convert to RabbitMqObject, Serialization Process starts
			BookInventoryInfo bookInventoryInfo = new BookInventoryInfo();
			bookInventoryInfo.setBookId(bookInventory.getBookId());
			bookInventoryInfo.setBookAvailable(bookInventory.getBookAvailable());			
			rabbitTemplate.convertSendAndReceive("myinventory.queue",bookInventoryInfo);

		} 
/*
		// Update the local inventory
		for(OrderItemRabbit orderItemRabbit:itemListRabbit) {
			
			 * From DeSearialised OrderItemInfo object, get bookId 
			 * and for respective bookId get inventory count of that book
			 * 
			int bookId = orderItemRabbit.getBookId();
			BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
			bookInventory.setBookAvailable(bookInventory.getBookAvailable()-orderItemRabbit.getQty());
			
			//updating local inventory
			bookInventory = bookInventoryDAO.save(bookInventory);
			
			//Update Remote Inventory using RabbitTemplate
			rabbitTemplate.convertSendAndReceive("myinventory.queue",bookInventory);

			//Update Remote Inventory using rest template
			/*RestTemplate bookSearchRest = new RestTemplate();
			String endPoint = "http://localhost:7000/updateBookInventory";
			bookSearchRest.put(endPoint, bookInventory);
			
		}
	*/
	}
	
	public void updateBookInventory(BookInventory bookInventoryInfo ) {
		System.out.println("PlaceOrder serviceImpl methd called");

		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookAvailable(bookInventoryInfo.getBookAvailable());
		bookInventory.setBookId(bookInventoryInfo.getBookId());
		bookInventoryDAO.save(bookInventory);
		
	}

}
