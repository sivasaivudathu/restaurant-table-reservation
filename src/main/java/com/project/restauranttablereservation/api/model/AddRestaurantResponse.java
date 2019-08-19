/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.Set;

import com.project.restauranttablereservation.dto.RestaurantBranchDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class AddRestaurantResponse extends BaseResponse {

	private RestaurantResponse  restaurant;

	public AddRestaurantResponse() {
		
	}
	
	public AddRestaurantResponse(RestaurantResponse restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public RestaurantResponse getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantResponse restaurant) {
		this.restaurant = restaurant;
	}
	
}
