/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.HashSet;
import java.util.Set;

import com.project.restauranttablereservation.models.RestaurantType;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantTypeService {

	public HashSet<RestaurantType> getRestaurantTypes(Set<String> restaurantTypes);
}
