/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.SeatingType;

/**
 * @author sivasaiv
 *
 */
public interface SeatingTypeRepository extends JpaRepository<SeatingType, Integer>{

	public Optional<SeatingType> findByType(String type);
	
}
