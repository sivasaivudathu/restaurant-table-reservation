/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.HashSet;
import java.util.Set;

import com.project.restauranttablereservation.models.Cuisine;

/**
 * @author sivasaiv
 *
 */
public interface CuisineService {

	public HashSet<Cuisine> getCuisines(Set<String> cuisines);
}
