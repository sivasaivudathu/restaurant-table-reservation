/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.repositories.ReservationSlotRepository;
import com.project.restauranttablereservation.service.ReservationSlotService;
import com.project.restauranttablereservation.service.SlotStatusService;

/**
 * @author sivasaiv
 *
 */
@Service
public class ReservationSlotServiceImpl implements ReservationSlotService {

	@Autowired
	SlotStatusService slotStatusService;
	
	@Autowired
	ReservationSlotRepository slotRepo;
	
	@Override
	public Set<ReservationSlot> getReservationSlots(Set<String> slots) {

		Set<ReservationSlot> reservationSlots = new HashSet<>();

		slots.forEach(slottime -> {
			ReservationSlot slot = new ReservationSlot(slottime, slotStatusService.getSlotStatus(SlotStatusType.AVAILABLE));
			reservationSlots.add(slot);
		});
		return reservationSlots;
	}

	@Override
	public ReservationSlot getBranchSlot(String time, int branchId) {
		
		return slotRepo.findByTimeAndBranch_Id(time, branchId);
	}

}
