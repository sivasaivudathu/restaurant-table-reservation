/**
 * 
 */
package com.project.restauranttablereservation.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sivasaiv
 *
 */

@Entity
@Table(name ="restaurant_branch")
public class RestaurantBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_id")
	private int id;
	
	private String city;
	
	private String address;
	
	private int capacity;
	
	@Column(name = "opens_at")
	private String opensAt;
	
	@Column(name = "closes_at")
	private String closesAt;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "rest_status_id")
	private RestaurantStatus status;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="branch_admin",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> admin;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_cuisine",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "cuisine_id",referencedColumnName = "id"))
	private Set<Cuisine> cuisines;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "type_id",referencedColumnName = "id"))
	private Set<RestaurantType> types;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_payment_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "payment_type_id",referencedColumnName = "id"))
	private Set<PaymentType> paymentTypes;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_seating_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "seating_type_id",referencedColumnName = "id"))
    private Set<SeatingType> seatingTypes;
	
	public RestaurantBranch() {
		
	}
	
	public RestaurantStatus getStatus() {
		return status;
	}

	public void setStatus(RestaurantStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
