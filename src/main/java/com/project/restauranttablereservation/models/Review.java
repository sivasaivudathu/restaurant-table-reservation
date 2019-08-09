/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sivasaiv
 *
 */

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private RestaurantBranch branch ;
	
	private String description;

	public Review(int id, User user, RestaurantBranch branch, String description) {
		this.id = id;
		this.user = user;
		this.branch = branch;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RestaurantBranch getBranch() {
		return branch;
	}

	public void setBranch(RestaurantBranch branch) {
		this.branch = branch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
