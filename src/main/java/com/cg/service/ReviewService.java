package com.cg.service;

import java.util.List;

import com.cg.dto.ReviewDto;
import com.cg.entity.Review;

public interface ReviewService {
	Review addNewReviewService(Review r, int prodId);
	List<ReviewDto> getReviewsByProdIdService(int prodId);
	Review updateRatingsService(int prodId,int revId,float newRatings);
     List<Review> searchByReviewerNames(String name);
}
 