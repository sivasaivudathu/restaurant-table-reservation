/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.api.model.AddBranchAdminRequest;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantBranchService {

	public RestaurantBranch generateBranch(RestaurantBranchDetails details);
	
	public void addRestaurantBranchAdmin(AddBranchAdminRequest request,int branchId);
	
	public RestaurantBranch getBranchById(int branchId);
}
