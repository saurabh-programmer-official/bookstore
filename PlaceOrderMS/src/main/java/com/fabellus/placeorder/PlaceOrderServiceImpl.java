package com.fabellus.placeorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{

	@Autowired
	OrderDAO orderDAO;
	@Autowired
	OrderItemDAO orderItemDAO;
	@Autowired
	BookInventoryDAO bookInventoryDAO;
	
	public List<Order> getOrdersByUserId(String userId) {
	// TODO Auto-generated method stub
	List<Order> orderList = orderDAO.findOrdersByUserId(userId);
		return orderList;

	}
	
	public Order placeOrder(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		//Save the order
		//Order info is coming from front end
		Order myorder = orderInfo.getOrder();
		Order ordersaved = orderDAO.save(myorder);//Primary key gets generated
		//Insert Order Item
		
		List<OrderItem> itemList =orderInfo.getItemList();
		for(OrderItem orderItemInfo: itemList) {
		OrderItem orderItempojo = new OrderItem(orderItemInfo.getOrderItemId(),ordersaved.getOrderId(),orderItemInfo.getBookId(),orderItemInfo.getQty(),orderItemInfo.getCost());
		orderItemDAO.save(orderItempojo);
		}


		for(OrderItem orderItem:itemList) {

			// Update the local inventory
			/*
			 * From DeSearialised OrderItemInfo object, get bookId 
			 * and for respective bookId get inventory count of that book
			 * */
			int bookId = orderItem.getBookId();
			BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
			bookInventory.setBookAvailable(bookInventory.getBookAvailable()-orderItem.getQty());
			bookInventory = bookInventoryDAO.save(bookInventory);

			//Update Remote Inventory
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put("http://localhost:7000/updateBookInventory", bookInventory);
		}
		return myorder;

	}
}
