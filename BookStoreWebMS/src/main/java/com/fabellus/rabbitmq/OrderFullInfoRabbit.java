package com.fabellus.rabbitmq;


import java.io.Serializable;
import java.util.List;

public class OrderFullInfoRabbit implements Serializable{
	private OrderRabbit order;
	private List<OrderItemRabbit> itemList;
	
	public OrderFullInfoRabbit() {
		super();
	}
	
	public OrderFullInfoRabbit(OrderRabbit order, List<OrderItemRabbit> itemList) {
		super();
		this.order = order;
		this.itemList = itemList;
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
