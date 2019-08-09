/**
 * 
 */
package com.project.restauranttablereservation.models;

import java.sql.Date;

import javax.persistence.Column;
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
public class Reservation {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "booked_at")
	private Date booked_at;
	
	
	private String name;
	
	@Column(name = "phone_no")
	private String phoneNumber;
	
	private int guests;
	
	@Column(name = "smoking_preference")
	private String smokingPreference;
	
	@Column(name = "booking_date")
	private Date bookingDate;
	
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "slot_id")
	private ReservationSlot slot;
	
	@ManyToOne
	@JoinColumn(name = "reservation_status_id")
	private ReservationStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private RestaurantBranch branch;
	
	@ManyToOne
	@JoinColumn(name = "seating_type_id")
	private SeatingType  seatingType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBooked_at() {
		return booked_at;
	}

	public void setBooked_at(Date booked_at) {
		this.booked_at = booked_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public String getSmokingPreference() {
		return smokingPreference;
	}

	public void setSmokingPreference(String smokingPreference) {
		this.smokingPreference = smokingPreference;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ReservationSlot getSlot() {
		return slot;
	}

	public void setSlot(ReservationSlot slot) {
		this.slot = slot;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
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

	public SeatingType getSeatingType() {
		return seatingType;
	}

	public void setSeatingType(SeatingType seatingType) {
		this.seatingType = seatingType;
	}
	
	
}
