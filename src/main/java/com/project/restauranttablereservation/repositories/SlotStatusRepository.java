/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.models.SlotStatus;

/**
 * @author sivasaiv
 *
 */
public interface SlotStatusRepository extends JpaRepository<SlotStatus, Integer>{

	public Optional<SlotStatus> findByStatus(SlotStatusType type);
}
