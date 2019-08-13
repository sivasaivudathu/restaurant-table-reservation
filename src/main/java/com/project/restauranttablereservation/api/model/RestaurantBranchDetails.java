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
public class RestaurantBranchDetails {

	@NotNull
	private String city;
	
	@NotNull
	private String address;
	
	@NotNull
	private int capacity;
	
	@NotNull
	private String opensAt;
	
	@NotNull
	private String closesAt;
	
	@NotNull
	private String status;
	
	@NotNull
	private Set<String> cuisines;
	
	@NotNull
	private Set<String> restauranttype;
	
	@NotNull
	private Set<String> paymentTypes;
	
	@NotNull
	 private Set<String> seating;
	 
	@NotNull
	 private Set<String> slots ;
	 
	@NotNull
	 private Set<String> phone;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getOpensAt() {
		return opensAt;
	}

	public void setOpensAt(String opensAt) {
		this.opensAt = opensAt;
	}

	public String getClosesAt() {
		return closesAt;
	}

	public void setClosesAt(String closesAt) {
		this.closesAt = closesAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<String> getCuisines() {
		return cuisines;
	}

	public void setCuisines(Set<String> cuisines) {
		this.cuisines = cuisines;
	}

	public Set<String> getRestauranttype() {
		return restauranttype;
	}

	public void setRestauranttype(Set<String> restauranttype) {
		this.restauranttype = restauranttype;
	}

	public Set<String> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(Set<String> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}

	public Set<String> getSeating() {
		return seating;
	}

	public void setSeating(Set<String> seating) {
		this.seating = seating;
	}

	public Set<String> getSlots() {
		return slots;
	}

	public void setSlots(Set<String> slots) {
		this.slots = slots;
	}

	public Set<String> getPhone() {
		return phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}

}
