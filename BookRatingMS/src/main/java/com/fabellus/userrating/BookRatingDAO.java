package com.fabellus.userrating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRatingDAO extends JpaRepository<BookRating, Integer>{
	


}
