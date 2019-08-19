/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;

/**
 * @author sivasaiv
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findBySlotAndBookingDate(ReservationSlot slot , Date date);
	
	List<Reservation> findByUser_Id(int id);
}
