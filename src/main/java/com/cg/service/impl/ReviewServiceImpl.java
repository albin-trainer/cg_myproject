package com.cg.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.ReviewDto;
import com.cg.entity.Product;
import com.cg.entity.Review;
import com.cg.repository.ProductRepository;
import com.cg.repository.ReviewRepository;
import com.cg.service.ReviewService;

@Component
@Transactional
public class ReviewServiceImpl  implements ReviewService{
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Override
	public Review addNewReviewService(Review r, int prodId) {
		//pulling the product entity
		System.out.println(prodId);
		Product p=prodRepo.findById(prodId).get();
		//setting the product in the review
		r.setDate(LocalDate.now());
		r.setProduct(p);//setting product into the review
		r=reviewRepo.save(r); //saving the review ...
		return r;
	}
	@Override
	public List<ReviewDto> getReviewsByProdIdService(int prodId) {
		Product p=prodRepo.findById(prodId).get();
		List<Review> reviews= p.getReviewList();
		List<ReviewDto> reviewsDto= new ArrayList<>();
		for(Review r:reviews) {
			ReviewDto rto=new ReviewDto();
			rto.setContent(r.getContent());
			rto.setRatings(r.getRatings());
			rto.setReviewerName(r.getReviewerName());
			reviewsDto.add(rto);
		}
		return reviewsDto;
	}
	@Override
	public Review updateRatingsService(int prodId, int revId,float newRatings) {
		//This we can do after the break ......
		int c=reviewRepo.editRatings(revId, newRatings);
		if(c>0) {
			Review r=reviewRepo.findById(revId).get();
			return r;
		}
		return null;
	}
	@Override
	public List<Review> searchByReviewerNames(String name) {
		return reviewRepo.findByReviewerName(name);
	}

}
