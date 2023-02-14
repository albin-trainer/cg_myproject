package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ReviewDto;
import com.cg.entity.Review;
import com.cg.service.ReviewService;

@RestController
@RequestMapping("products/{prodCode}/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@PostMapping
	Review addNewReview(@RequestBody Review r, 
			@PathVariable("prodCode")  int prodId) {
		return  reviewService.addNewReviewService(r, prodId);
	}
	@GetMapping
	public List<ReviewDto> findAllReviewsByProductId( @PathVariable int prodCode){
		return reviewService.getReviewsByProdIdService(prodCode);
	}
	@PutMapping("/{revId}/{ratings}")
	public Review updateRatings(@PathVariable("prodCode") int  prodCode, 
			@PathVariable ("revId") int reviewId, @PathVariable("ratings")  float newRatings) {
		return reviewService.updateRatingsService(prodCode, reviewId, newRatings);
	}
	
	@GetMapping("/search/{name}")
	public List<Review> findByReviewerNames( @PathVariable String name){
		return reviewService.searchByReviewerNames(name);
	}
}
