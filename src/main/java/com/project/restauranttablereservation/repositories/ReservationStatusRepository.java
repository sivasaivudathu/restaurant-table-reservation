/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.ReservationStatus;

/**
 * @author sivasaiv
 *
 */
public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer>{

	public ReservationStatus findByStatus(String status);
}
