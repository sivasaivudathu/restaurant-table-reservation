/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.models.SlotStatus;

/**
 * @author sivasaiv
 *
 */
public interface SlotStatusService {

	public SlotStatus getSlotStatus(SlotStatusType type);
}
