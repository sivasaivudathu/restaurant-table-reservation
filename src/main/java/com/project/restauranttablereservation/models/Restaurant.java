/**
 * 
 */
package com.project.restauranttablereservation.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author sivasaiv
 *
 */

@Entity
public class Restaurant {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private int id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Set<RestaurantBranch> branches;

    public Restaurant() {
    	
    
    }
	public Restaurant(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<RestaurantBranch> getBranches() {
		return branches;
	}
	public void setBranches(Set<RestaurantBranch> branches) {
		this.branches = branches;
	}
	
	public void addBranch(RestaurantBranch branch) {
		if (branch != null) {
			if (branches == null) {
				branches = new HashSet<>();
			}
			branches.add(branch);
		}

	}
	
}
