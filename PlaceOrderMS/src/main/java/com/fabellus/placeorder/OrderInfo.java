package com.fabellus.placeorder;

import java.util.List;

public class OrderInfo {
	private Order order;
	private List<OrderItem> itemList;
	
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(Order order, List<OrderItem> itemList) {
		super();
		this.order = order;
		this.itemList = itemList;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}
}
