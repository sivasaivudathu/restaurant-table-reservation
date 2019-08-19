/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.List;

/**
 * @author sivasaiv
 *
 */
public class AddBranchAdminRequest {

	List<Integer> userid ;

	public List<Integer> getUserid() {
		return userid;
	}

	public void setUserid(List<Integer> userid) {
		this.userid = userid;
	}
}
