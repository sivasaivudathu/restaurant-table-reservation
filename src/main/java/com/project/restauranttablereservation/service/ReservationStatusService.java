/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.models.ReservationStatus;

/**
 * @author sivasaiv
 *
 */
public interface ReservationStatusService {

	public ReservationStatus getReservationStatus(String status);
}
