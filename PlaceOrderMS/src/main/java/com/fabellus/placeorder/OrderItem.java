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
@Table(name="myorderitems", schema = "jlcorderdb")
//@ApiModel("OrderItem consisting of orderItemId, bookId , Qty, Cost")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_gen")
	@SequenceGenerator(name = "order_gen", sequenceName = "myorderId_gen",initialValue = 1236,allocationSize = 1,schema = "jlcorderdb")
	@Column(name="order_item_id")
//	@ApiModelProperty("Holds the orderItemId Primary key")
	private int orderItemId;
	
	@Column(name="order_id")
//	@ApiModelProperty("Holders the order Id number")
	private int orderId;
	
	@Column(name="book_id")
//	@ApiModelProperty("Holds the Book Id number")
	private int bookId;
	
	@Column(name="qty")
//	@ApiModelProperty("Holds the quantity")
	private int qty;
	
	@Column(name="cost")
//	@ApiModelProperty("Holds the total cost")
	private double cost;


	public OrderItem(int orderId, int bookId, int qty, double cost) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

	public OrderItem() {
		super();
	}

	public OrderItem(int orderItemId, int orderId, int bookId, int qty, double cost) {
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
