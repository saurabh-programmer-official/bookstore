package com.fabellus.userrating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingDAO extends JpaRepository<UserRating, Integer>{
	
	public List<UserRating> getUserRatingsByUserId(String userId);
	public List<UserRating> getUserRatingsByBookId(int bookId);
	

	
}
