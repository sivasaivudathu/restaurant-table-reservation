/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantBranchService {

	public RestaurantBranch generateBranch(RestaurantBranchDetails details);
}
