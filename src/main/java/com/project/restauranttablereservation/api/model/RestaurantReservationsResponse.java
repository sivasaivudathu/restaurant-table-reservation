/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.List;

import com.project.restauranttablereservation.dto.RestaurantReservationDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class RestaurantReservationsResponse extends BaseResponse {

	List<RestaurantReservationDto> reservations;

	public RestaurantReservationsResponse() {
		
	}
	
	public RestaurantReservationsResponse(List<RestaurantReservationDto> reservations) {
		this.reservations = reservations;
	}

	public List<RestaurantReservationDto> getReservations() {
		return reservations;
	}

	public void setReservations(List<RestaurantReservationDto> reservations) {
		this.reservations = reservations;
	}
	
	
}
