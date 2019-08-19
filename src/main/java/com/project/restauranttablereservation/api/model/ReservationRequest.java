/**
 * 
 */
package com.project.restauranttablereservation.api.model;

/**
 * @author sivasaiv
 *
 */
public class ReservationRequest {

	
	private int userId;
	
	private int branchId;
	
	private String name;
	
	private String phoneNumber;
	
	private int guests;
	
	private String seatingPreference;
	
	private String smokingPreference;
	
	private String bookingDate;
	
	private String time;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public String getSeatingPreference() {
		return seatingPreference;
	}

	public void setSeatingPreference(String seatingPreference) {
		this.seatingPreference = seatingPreference;
	}

	public String getSmokingPreference() {
		return smokingPreference;
	}

	public void setSmokingPreference(String smokingPreference) {
		this.smokingPreference = smokingPreference;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
