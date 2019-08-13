/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.HashSet;
import java.util.Set;

import com.project.restauranttablereservation.models.SeatingType;

/**
 * @author sivasaiv
 *
 */
public interface SeatingTypeService {

	public HashSet<SeatingType> getSeatingTypes(Set<String> seatingTypes);
}
