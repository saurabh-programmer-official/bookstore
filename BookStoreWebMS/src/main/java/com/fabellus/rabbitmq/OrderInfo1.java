package com.fabellus.rabbitmq;

import java.io.Serializable;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//@ApiModel("oRDER DTO")
public class OrderInfo1 implements Serializable{

	public OrderInfo1() {
		super();
	}

	//@ApiModelProperty("holds the ordr Id")
	int orderId;
	

	//@ApiModelProperty("Holds the order date")
	String orderDate;
	

	//@ApiModelProperty("Holds the user Id")
	String userId;
	

	//@ApiModelProperty("Holds the total Qty")
	int totalQty;
	

	//@ApiModelProperty("holds thre total cost of the order")
	double totalCost;
	

	//@ApiModelProperty("holds the active or inactive status of the order")
	String status;


	public OrderInfo1(String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	public OrderInfo1(int orderId, String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", userId=" + userId + ", totalQty="
				+ totalQty + ", totalCost=" + totalCost + ", status=" + status + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
