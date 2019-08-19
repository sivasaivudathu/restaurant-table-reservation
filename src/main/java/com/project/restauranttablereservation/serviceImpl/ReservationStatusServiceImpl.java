/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.models.ReservationStatus;
import com.project.restauranttablereservation.repositories.ReservationStatusRepository;
import com.project.restauranttablereservation.service.ReservationStatusService;

/**
 * @author sivasaiv
 *
 *
 */
@Service
public class ReservationStatusServiceImpl implements ReservationStatusService {

	@Autowired
	ReservationStatusRepository statusRepository;
	
	public ReservationStatus getReservationStatus(String status) {
		
		return statusRepository.findByStatus(status);
	}
}
