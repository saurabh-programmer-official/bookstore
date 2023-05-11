package com.fabellus.userrating;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabellus.rabbitmq.BookRatingInfo;
import com.fabellus.rabbitmq.UserRatingInfo;


@Service
@Transactional
public class UserRatingServiceImpl implements RatingService{

	@Autowired
	UserRatingDAO userRatingDAO;
	@Autowired
	BookRatingDAO bookRatingDAO;
	@Autowired
	RabbitTemplate rabbitTemplate;

	
	@RabbitListener(queues="myuserratings.queue")
	public void addUserRating(UserRatingInfo userRatingInfo) {
		// TODO Auto-generated method stub
		System.out.println("UserRatingImpl "+userRatingInfo);
		UserRating userRating = new UserRating(userRatingInfo.getRatingId(),userRatingInfo.getBookId(),userRatingInfo.getUserId(),userRatingInfo.getRating(),userRatingInfo.getReview());
		userRatingDAO.save(userRating);//User rating saved.
		
		//Calculate the Avg Rating for BookId
		int bookId = userRating.getBookId();
		System.out.println("bookId: "+bookId);
		double rating= userRating.getRating();
		List<UserRating> userRatingByBookIdList = userRatingDAO.getUserRatingsByBookId(bookId);
		double sum = 0;
		for(UserRating userRatingByBookId: userRatingByBookIdList) {
			sum = sum + userRatingByBookId.getRating();
		}
		double average = sum/userRatingByBookIdList.size();
		System.out.println("sum: " + sum + "Count: " + userRatingByBookIdList.size() + " avg: "+ average);
		
		//Update Local database of Rating
		//Step 1. find the book who's rating has to be updated by using findbyId() method
		Optional<BookRating>opt = bookRatingDAO.findById(bookId);
		BookRating bookRating	=null;
		if(opt.isPresent()) {
		bookRating	= opt.get();
		System.out.println("1. bookRatingId+"+ bookRating);

		System.out.println("2. bookRatingId+"+ bookRating.getBookId());
//		bookRating.setBookId(bookId);
		bookRating.setRating((average));//setter method
		bookRating.setNumber_of_searches(50);
		bookRating = bookRatingDAO.save(bookRating); //persistence operation
		System.out.println("3. bookRatingId+"+ bookRating.getBookId());

		}else
		{
			System.out.println("5. bookRatingId+"+ bookRating);

		 bookRating	= new BookRating(); //new BookRating object made
		 bookRating.setBookId(bookId);
		 bookRating.setRating(rating);
		 bookRating.setNumber_of_searches(50);
		 bookRating = bookRatingDAO.save(bookRating);
		}
		
		//Use RabbitMqTemplate to update BookSearchMS book rating
		BookRatingInfo bookRatingInfo = new BookRatingInfo();
		bookRatingInfo.setBookId(bookRating.getBookId());
		bookRatingInfo.setNumber_of_searches(bookRating.getNumber_of_searches());
		bookRatingInfo.setRating(bookRating.getRating());
		System.out.println("4. bookRatingInfo+"+ bookRatingInfo.getBookId());

		rabbitTemplate.convertAndSend("mybookratings.queue", bookRatingInfo);
		
		/*
		//Remote database updating using rest template
		RestTemplate ratingTemplate = new RestTemplate();
		String url ="http://localhost:7000/updateBookRating";
		ratingTemplate.put(url, bookRating);
		*/
	}
	
	public List<UserRating> getUserRatingsByBookId(int bookId){
		return userRatingDAO.getUserRatingsByBookId(bookId);		
	}
	public List<UserRating> getUserRatingsByUserId(String userId){
		return userRatingDAO.getUserRatingsByUserId(userId);
		
	}
}
