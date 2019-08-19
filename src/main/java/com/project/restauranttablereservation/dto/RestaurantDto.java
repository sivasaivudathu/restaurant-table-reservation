/**
 * 
 */
package com.project.restauranttablereservation.dto;

import java.util.Set;

/**
 * @author sivasaiv
 *
 */
public class RestaurantDto {

	private String  name;
	
	private int id;
	
	private Set<RestaurantBranchDto> branches;

	public RestaurantDto() {
		
	}
	public RestaurantDto(String name, int id, Set<RestaurantBranchDto> branches) {
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
