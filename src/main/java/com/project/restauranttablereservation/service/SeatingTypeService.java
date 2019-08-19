/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.Set;

import com.project.restauranttablereservation.models.SeatingType;

/**
 * @author sivasaiv
 *
 */
public interface SeatingTypeService {

	public Set<SeatingType> getSeatingTypes(Set<String> seatingTypes);
	
	public SeatingType getSeatingType(String seatingType);
}
