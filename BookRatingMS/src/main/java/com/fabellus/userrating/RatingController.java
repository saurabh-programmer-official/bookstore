
package com.fabellus.userrating;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@ApiModel("UserRatingController")
public class RatingController {
	static Logger log = LoggerFactory.getLogger(RatingController.class);

	@Autowired
	RatingService userRatingService;
	/*
	 * We are making this Asynchronous
	@PostMapping("/addUserRating")
	@ApiOperation(value = "addUserRating" ,response = void.class)
	public void addUserRating(@RequestBody UserRating userRating) {
		userRatingService.addUserRating(userRating);
	}
	*/
	@GetMapping("/getUserRatings/{userId}")
	@ApiOperation(value="getUserRatingByUserId", response=UserRating.class, notes="Get USer rating by Book Id")
	public List<UserRating> getUserRatingByUserId(@PathVariable String userId){
		return userRatingService.getUserRatingsByUserId(userId);
	}
	
	@GetMapping("/getBookRatingByBookId/{bookId}")
	@ApiOperation(value = "getUserRatingByBookId", response=UserRating.class,notes="User rating by Book id")
	public List<UserRating> getUserRatingByBookId(@PathVariable int bookId){
		return userRatingService.getUserRatingsByBookId(bookId);
	}
}