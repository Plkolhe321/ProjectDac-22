package com.paradise.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.paradise.entity.Review;
import com.paradise.entity.Visitor;

import com.paradise.repository.ReviewRepository;
import com.paradise.repository.VisitorRepository;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private VisitorRepository visitorRepository;

	public List<Review> fetchAllReview() {
		
		List<Review> list = (List<Review>) reviewRepository.findAll();
		return list;
	}
	public List<Review> fetchReview(int visitorId) {
		
		List<Review> reviewList = reviewRepository.findIdByUserId(visitorId);
		return reviewList;
	}

	
	public String addReview(String username,Review review) {
		System.out.println(username+"	"+review.getDescription());
		
		
			System.out.println(review.getDescription()+"hfjkshkj");
			review.setVisitor(visitorRepository.findByUserName(username));
			reviewRepository.save(review);
	
			return "Review Added Successfully";
	}

	boolean isVisitorPresent(int visitorId,Review review) {
		System.out.println(review.getDescription()+"akashbarhate1");
		
		try {
		Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
		
		System.out.println(review);
			}catch(NoSuchElementException e) {
			
			return true;
		}
		return false;
	}
	
	

	
boolean isReviewPresent(int reviewId) {
		
		try {
			reviewRepository.findById(reviewId).get();
		}catch(NoSuchElementException e) {
			
			return false;
		}
		return true;
	}
	
	
	
public String removeReview(int reviewId) {

		if(isReviewPresent(reviewId)) {
			reviewRepository.deleteReview(reviewId);
			return "Review removed successfully.";
		}
			else
				return "Visitor not exist.";
	}
	
}