/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

/**
 * @author sivasaiv
 *
 */
public class AddRestaurantRequest {

	@NotNull
	private String name;
	
	private Set<RestaurantBranchDetails> branches;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RestaurantBranchDetails> getBranches() {
		return branches;
	}

	public void setBranches(Set<RestaurantBranchDetails> branches) {
		this.branches = branches;
	}
	
	
	
}
