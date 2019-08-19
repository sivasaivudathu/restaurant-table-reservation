/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class RestaurantResponse extends BaseResponse{

    RestaurantDto restaurant;

    public RestaurantResponse() {
    	
    }
    
	public RestaurantResponse(RestaurantDto restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
}