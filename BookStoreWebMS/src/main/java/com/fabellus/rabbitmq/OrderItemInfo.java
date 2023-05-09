package com.fabellus.rabbitmq;

import java.io.Serializable;

/*
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
*/
//@ApiModel("OrderItem consisting of orderItemId, bookId , Qty, Cost")
public class OrderItemInfo implements Serializable{

	//@ApiModelProperty("Holds the orderItemId Primary key")
	private int orderItemId;	
	//@ApiModelProperty("Holders the order Id number")
	private int orderId;
	
	//@ApiModelProperty("Holds the Book Id number")
	private int bookId;
	
	//@ApiModelProperty("Holds the quantity")
	private int qty;
	
	//@ApiModelProperty("Holds the total cost")
	private double cost;

	public OrderItemInfo(int orderId, int bookId, int qty, double cost) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

	public OrderItemInfo() {
		super();
	}

	public OrderItemInfo(int orderItemId, int orderId, int bookId, int qty, double cost) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

		@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", bookId=" + bookId + ", qty=" + qty
				+ ", cost=" + cost + "]";
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}	
}
