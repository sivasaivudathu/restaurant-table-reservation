/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.Set;

import com.project.restauranttablereservation.Dto.RestaurantBranchDto;

/**
 * @author sivasaiv
 *
 */
public class RestaurantResponse {

private String  name;
	
	private int id;
	
	private Set<RestaurantBranchDto> branches;

	public RestaurantResponse() {
		
	}
	public RestaurantResponse(String name, int id, Set<RestaurantBranchDto> branches) {
		this.name = name;
		this.id = id;
		this.branches = branches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<RestaurantBranchDto> getBranches() {
		return branches;
	}

	public void setBranches(Set<RestaurantBranchDto> branches) {
		this.branches = branches;
	}
}
