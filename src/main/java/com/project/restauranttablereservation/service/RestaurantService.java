/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.request.model.AddRestaurantBranchRequest;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantService {

	public BaseResponse addRestaurant(Restaurant restaurant);
	
	public BaseResponse addRestaurantBranch(int restaurentId,AddRestaurantBranchRequest req);
	
}
