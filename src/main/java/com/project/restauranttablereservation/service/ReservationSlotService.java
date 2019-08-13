/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.Set;

import com.project.restauranttablereservation.models.ReservationSlot;

/**
 * @author sivasaiv
 *
 */
public interface ReservationSlotService {

	public Set<ReservationSlot> getReservationSlots(Set<String> slots);
}
