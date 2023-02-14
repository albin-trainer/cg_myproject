package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.entity.Review;
@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer>{
	//in default this supports only select queries
	@Query(value = "update Review set ratings = :new_ratings where revId = :rid")
	@Modifying//to support for update, insert and delete queries
  int editRatings( @Param("rid") int revId,  @Param("new_ratings")float newRatings);
	
	//query method (Spring provides the implementation @ run time)
	List<Review> findByReviewerName(String name);
}
