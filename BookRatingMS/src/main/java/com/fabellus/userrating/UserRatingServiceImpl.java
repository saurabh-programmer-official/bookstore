package com.fabellus.userrating;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
@Transactional
public class UserRatingServiceImpl implements UserRatingService{

	@Autowired
	UserRatingDAO userRatingDAO;
	@Autowired
	BookRatingDAO bookRatingDAO;
	
	public void addUserRating(UserRating userRating) {
		// TODO Auto-generated method stub
		
		//Local User rating save
		userRatingDAO.save(userRating);
		
		int bookId = userRating.getBookId();
		System.out.println("bookId: "+bookId);
		double rating= userRating.getRating();
		List<UserRating> userRatingListByBookId = userRatingDAO.getUserRatingsByBookId(bookId);
		double sum = 0;
		for(UserRating userRatingByBookId: userRatingListByBookId) {
			sum = sum + userRatingByBookId.getRating();
		}
		double average = sum/userRatingListByBookId.size();
		System.out.println("avg"+ average);
		
		//Update Local database of Book Rating
		
		Optional<BookRating>opt = bookRatingDAO.findById(bookId);
		BookRating bookRating	=null;
		if(opt.isPresent()) {
		bookRating	= opt.get();
		bookRating.setRating((average));//setter method
		bookRatingDAO.save(bookRating); //persistence operation
		}else
		{
		 bookRating	= new BookRating(); //new BookRating object made
		 bookRating.setBookId(bookId);
		 bookRating.setRating(rating);
		 bookRating.setNumber_of_searches(50);
		 bookRatingDAO.save(bookRating);
		}
		
		
//		Remote database updating using rest template
		RestTemplate ratingTemplate = new RestTemplate();
		String url ="http://localhost:7000/updaterating";
		ratingTemplate.put(url, bookRating);
	}
	
	public List<UserRating> getUserRatingsByBookId(int bookId){
		return userRatingDAO.getUserRatingsByBookId(bookId);		
	}
	public List<UserRating> getUserRatingsByUserId(String userId){
		return userRatingDAO.getUserRatingsByUserId(userId);
		
	}
}