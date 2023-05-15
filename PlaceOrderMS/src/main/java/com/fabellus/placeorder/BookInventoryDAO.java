package com.fabellus.placeorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInventoryDAO extends JpaRepository<BookInventory, Integer>{

}
