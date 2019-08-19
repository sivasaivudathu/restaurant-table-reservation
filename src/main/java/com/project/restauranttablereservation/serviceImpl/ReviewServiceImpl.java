/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.ReviewRequest;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Review;
import com.project.restauranttablereservation.repositories.ReviewRepository;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.ReviewService;

/**
 * @author sivasaiv
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	UserDetailsServiceImpl userService;
	
	@Autowired
	RestaurantBranchService branchService;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public BaseResponse addReview(ReviewRequest request) {
		
		Review review = new Review();
		
		review.setUser(userService.getUserById(request.getUserId()));
		review.setBranch(branchService.getBranchById(request.getBranchId()));
		review.setDescription(request.getDescription());
		
		long millis = System.currentTimeMillis();
		review.setDate(new Date(millis));
		
		reviewRepository.save(review);
		
		return new BaseResponse("SUCCUSS", "Review Added Successfully");
		
	}

}
