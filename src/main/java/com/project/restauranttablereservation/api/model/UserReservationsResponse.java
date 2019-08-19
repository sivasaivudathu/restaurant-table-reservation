/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.List;

import com.project.restauranttablereservation.dto.ReservationDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class UserReservationsResponse extends BaseResponse{

	private List<ReservationDto> reservations;

	public UserReservationsResponse() {
		
	}
	
	public UserReservationsResponse(List<ReservationDto> reservations) {
		super();
		this.reservations = reservations;
	}

	public List<ReservationDto> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDto> reservations) {
		this.reservations = reservations;
	}
	
}
