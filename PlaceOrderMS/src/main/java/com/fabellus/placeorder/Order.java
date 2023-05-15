package com.fabellus.placeorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="myorder", schema = "jlcorderdb")
//@ApiModel("Order table/class consists of orderId, date, userId, cost, status")
public class Order {

	public Order() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
	@SequenceGenerator(name = "order_gen",sequenceName = "orderId_gen", schema = "jlcorderdb",allocationSize = 1,initialValue = 5005)
	@Column(name="order_id")
//	@ApiModelProperty("holds the ordr Id")
	int orderId;
	
	@Column(name="order_date")
//	@ApiModelProperty("Holds the order date")
	String orderDate;
	
	@Column(name="user_id")
//	@ApiModelProperty("Holds the user Id")
	String userId;
	
	@Column(name="total_qty")
//	@ApiModelProperty("Holds the total Qty")
	int totalQty;
	
	@Column(name="total_cost")
//	@ApiModelProperty("holds thre total cost of the order")
	double totalCost;
	
	@Column(name="status")
//	@ApiModelProperty("holds the active or inactive status of the order")
	String status;


	public Order(String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	public Order(int orderId, String orderDate, String userId, int totalQty, double totalCost, String status) {
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
