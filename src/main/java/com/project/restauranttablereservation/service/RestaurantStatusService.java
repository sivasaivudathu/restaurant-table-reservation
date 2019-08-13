/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.RestaurantStatus;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantStatusService {

	public RestaurantStatus getRestaurantStatus(RestaurantStatusType type);
}









