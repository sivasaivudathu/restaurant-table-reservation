/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.sql.Date;
import java.util.List;

import com.project.restauranttablereservation.api.model.ReservationRequest;
import com.project.restauranttablereservation.api.model.UserReservationsResponse;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;

/**
 * @author sivasaiv
 *
 */
public interface ReservationService {

	public List<Reservation> getReservations(ReservationSlot slot,Date date);
	
	public BaseResponse addReservation(ReservationRequest request);
	
	public UserReservationsResponse getUserReservations(int userId);
}
