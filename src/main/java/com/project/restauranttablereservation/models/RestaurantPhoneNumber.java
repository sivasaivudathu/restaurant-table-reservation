package com.project.restauranttablereservation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="branch_phonenumber")
public class RestaurantPhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String number;
	private String type;

	@ManyToOne(optional = false)
	@JoinColumn(name = "branch_id")
	private RestaurantBranch branch;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RestaurantBranch getBranch() {
		return branch;
	}

	public void setBranch(RestaurantBranch branch) {
		this.branch = branch;
	}

	

}
