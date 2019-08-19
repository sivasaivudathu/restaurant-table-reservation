/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.api.model.ReviewRequest;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public interface ReviewService {

	public BaseResponse addReview(ReviewRequest request);
}
