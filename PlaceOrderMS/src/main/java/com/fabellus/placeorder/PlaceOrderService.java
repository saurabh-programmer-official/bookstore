package com.fabellus.placeorder;

import java.util.List;

import com.fabellus.placeorder.BookInventory;

public interface PlaceOrderService {

//	public OrderInfo placeOrder(OrderInfo orderInfo);
	public List<Order> getOrdersByUserId(String userId);
//	public void updateBookInventory(BookInventory bookInventory);
}
