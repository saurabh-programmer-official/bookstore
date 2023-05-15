package com.fabellus.bookstoreweb;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="UserRatingMS")
public interface UserRatingProxy {
	@GetMapping("/getUserRatings/{userId}")
	public List<UserRating> getUserRatingByUserId(@PathVariable("userId") String userId);
	
	@GetMapping("/getUserRatingByBookId/{bookId}")
	public List<UserRating> getUserRatingByBookId(@PathVariable("bookId") int bookId);
	
}
