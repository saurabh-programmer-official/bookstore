package com.fabellus.userrating;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface RatingService {
	//public void addUserRating(UserRating userRating);
	public List<UserRating> getUserRatingsByBookId(int bookId);
	public List<UserRating> getUserRatingsByUserId(String userId);
}