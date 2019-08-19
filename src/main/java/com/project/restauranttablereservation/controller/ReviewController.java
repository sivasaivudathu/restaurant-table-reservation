/**
 * 
 */
package com.project.restauranttablereservation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.api.model.ReviewRequest;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.service.ReviewService;

/**
 * @author sivasaiv
 *
 */
@RestController
public class ReviewController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/reviews")
	@ResponseBody
	public BaseResponse addReview(@Valid @RequestBody ReviewRequest request) {
		logger.info("ReviewController/addReview...");
		return reviewService.addReview(request);
	}
	
	
	
}
