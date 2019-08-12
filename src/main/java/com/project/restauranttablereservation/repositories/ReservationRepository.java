/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Reservation;

/**
 * @author sivasaiv
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
