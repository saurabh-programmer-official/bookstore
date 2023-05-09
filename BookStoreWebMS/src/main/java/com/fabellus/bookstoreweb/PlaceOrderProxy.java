package com.fabellus.bookstoreweb;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="PlaceOrderMS")
public interface PlaceOrderProxy {

	@GetMapping("/myorders/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable String userId);
	
	
}
