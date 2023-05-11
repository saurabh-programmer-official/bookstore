package com.fabellus.placeorder;

import java.util.List;

public interface PlaceOrderService {

	public Order placeOrder(OrderInfo orderInfo);
	public List<Order> getOrdersByUserId(String userId);
	
}
