package com.fabellus.placeorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabellus.placeorder.BookInventory;

import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
//@ApiModel("PlaceOrder Controller class with 2 methods")
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;

	@GetMapping("/myorders/{userId}")
	@ApiOperation(value = "getOrdersByUserId",response = Order.class, notes = "List of orders")
	public List<Order> getOrdersByUserId(@PathVariable String userId){
		System.out.println("Controller called");
		return placeOrderService.getOrdersByUserId(userId);
		
	}
	/*
	@PostMapping("/placeorder")
	@ApiOperation(value = "placeOrders",response = Order.class, notes = "List of orders")
	public OrderInfo placeholder(@RequestBody OrderInfo orderInfo) {
		System.out.println("PlaceOrdr MS: REst COntroller");
		OrderInfo orderInfo1=placeOrderService.placeOrder(orderInfo);
		return orderInfo1;
	}
	@PutMapping("/updateBookInventory")
	@ApiOperation(value="updateBookInventory",response = void.class, notes="Updates the inventory of Book")
	public void updateBookInventory(@RequestBody BookInventory bookInventory) {
		System.out.println("--Book Search Controller-- updateBookInventory--");
		placeOrderService.updateBookInventory(bookInventory);
	}
	*/
	
}
