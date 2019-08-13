/**
 * 
 */
package com.project.restauranttablereservation.Dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
public class RestaurantBranchDto {

	private int id;
	
	private String city;
	
	private String address;
	
	private String opensAt;
	
	private String closesAt;
	
	private String status;
	
	private Set<String> cuisines;
	
	private Set<String> restaurantType;
	
	private Set<String> paymentTypes;
	
	 private Set<String> seating;
	 
	 private Set<String> phone;
	 
	 public RestaurantBranchDto() {
		 
	 }
	 
	 public RestaurantBranchDto (RestaurantBranch branch) {
		 this.id = branch.getId();
		 this.city = branch.getCity();
		 this.address = branch.getAddress();
		 this.closesAt= branch.getClosesAt();
		 this.opensAt= branch.getOpensAt();
		 this.status = branch.getStatus().getStatus().name();
		 this.cuisines = branch.getCuisines().stream().map(cuisine -> cuisine.getName()).collect(Collectors.toSet());
		 this.paymentTypes = branch.getPaymentTypes().stream().map(paymentType -> paymentType.getType()).collect(Collectors.toSet());
		 this.seating = branch.getSeatingTypes().stream().map(seatingType -> seatingType.getType()).collect(Collectors.toSet());
		 this.restaurantType = branch.getTypes().stream().map(restType -> restType.getType()).collect(Collectors.toSet());
		 this.phone = branch.getPhone().stream().map(phone -> phone.getNumber()).collect(Collectors.toSet());
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<String> getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(Set<String> restaurantType) {
		this.restaurantType = restaurantType;
	}

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
		return restaurantType;
	}

	public void setRestauranttype(Set<String> restauranttype) {
		this.restaurantType = restauranttype;
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


	public Set<String> getPhone() {
		return phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}
	 
}
