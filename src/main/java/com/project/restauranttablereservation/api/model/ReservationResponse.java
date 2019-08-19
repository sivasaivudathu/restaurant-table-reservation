/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.Set;

import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class ReservationResponse extends BaseResponse {

	private int id;
	
	private String name ;
	
	private String restaurant;
	
	private String address;
	
	private String city;
	
	private Set<String> contactNumbers;
	
	private String time;
	
	public ReservationResponse() {
		
	}

	
	

	public ReservationResponse(int id, String name, String restaurant, String address, String city,
			Set<String> contactNumbers, String time) {
		super();
		this.id = id;
		this.name = name;
		this.restaurant = restaurant;
		this.address = address;
		this.city = city;
		this.contactNumbers = contactNumbers;
		this.time = time;
	}




	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<String> getContactNumbers() {
		return contactNumbers;
	}




	public void setContactNumbers(Set<String> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	
}
