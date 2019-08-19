/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.List;

import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantSlotsResponse;
import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantService extends BaseService{

	public RestaurantResponse addRestaurant(AddRestaurantRequest request) ;
	
	public BaseResponse addRestaurantBranch(int restaurentId,RestaurantBranchDetails details);
	
	public RestaurantResponse getRestaurant(int id);
	
	public List<RestaurantDto> getRestaurants();
	
	public List<RestaurantDto> getRestaurants(String city);
	
	public RestaurantSlotsResponse getRestaurantSlots(int branchId,String dateString);
	
}
