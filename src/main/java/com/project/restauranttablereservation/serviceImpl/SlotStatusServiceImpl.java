/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.models.SlotStatus;
import com.project.restauranttablereservation.repositories.SlotStatusRepository;
import com.project.restauranttablereservation.service.SlotStatusService;

/**
 * @author sivasaiv
 *
 */
@Service
public class SlotStatusServiceImpl implements SlotStatusService {

	@Autowired
	SlotStatusRepository slotStatuRepo;
	
	@Override
	public SlotStatus getSlotStatus(SlotStatusType type) {

		Optional<SlotStatus> optionalStatus = slotStatuRepo.findByStatus(type);
		if (optionalStatus.isPresent()) {
			return optionalStatus.get();
		}

		return new SlotStatus(type);
	}

}
