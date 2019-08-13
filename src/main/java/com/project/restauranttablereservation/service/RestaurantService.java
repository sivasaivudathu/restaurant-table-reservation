/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.List;

import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.AddRestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantService extends BaseService{

	public AddRestaurantResponse addRestaurant(AddRestaurantRequest request);
	
	public BaseResponse addRestaurantBranch(int restaurentId,RestaurantBranchDetails details);
	
	public AddRestaurantResponse getRestaurant(int id);
	
	public List<RestaurantResponse> getRestaurants();
	
	public List<RestaurantResponse> getRestaurants(String city);
	
}
