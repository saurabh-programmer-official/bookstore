package com.fabellus.placeorder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer>{

	List<Order> findOrdersByUserId(String userId);
}
