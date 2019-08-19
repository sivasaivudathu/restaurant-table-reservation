/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sivasaiv
 *
 */
public class ReviewRequest {

	@NotNull
	private int userId;
	
	@NotNull
	private int branchId;
	
	@NotBlank
	private String description;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
