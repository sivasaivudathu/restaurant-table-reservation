/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.restauranttablereservation.constants.RestaurantStatusType;

/**
 * @author sivasaiv
 *
 */
@Entity
@Table(name ="restaurant_status")
public class RestaurantStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="rest_status_id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private RestaurantStatusType status;

	public RestaurantStatus(int id, RestaurantStatusType status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RestaurantStatusType getStatus() {
		return status;
	}

	public void setStatus(RestaurantStatusType status) {
		this.status = status;
	}
	
	
	
}

