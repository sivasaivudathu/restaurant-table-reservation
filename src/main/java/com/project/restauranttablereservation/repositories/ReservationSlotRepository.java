/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.ReservationSlot;

/**
 * @author sivasaiv
 *
 */
public interface ReservationSlotRepository extends JpaRepository<ReservationSlot,Integer> {

	public ReservationSlot findByTimeAndBranch_Id(String time,int id);
}
