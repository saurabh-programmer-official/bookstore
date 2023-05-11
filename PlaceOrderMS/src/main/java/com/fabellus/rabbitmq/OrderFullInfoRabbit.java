package com.fabellus.rabbitmq;

import java.io.Serializable;
import java.util.List;

import com.fabellus.placeorder.Order;
import com.fabellus.placeorder.OrderItem;

public class OrderFullInfoRabbit implements Serializable{
	private OrderRabbit order;
	private List<OrderItemRabbit> itemList;
	

	public OrderFullInfoRabbit(OrderRabbit order, List<OrderItemRabbit> itemList) {
		super();
		this.order = order;
		this.itemList = itemList;
	}

	public OrderFullInfoRabbit() {
		super();
	}

	public OrderRabbit getOrder() {
		return order;
	}

	public void setOrder(OrderRabbit order) {
		this.order = order;
	}

	public List<OrderItemRabbit> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItemRabbit> itemList) {
		this.itemList = itemList;
	}
}
