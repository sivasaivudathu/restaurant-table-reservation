/**
 * 
 */
package com.project.restauranttablereservation.dto;

import com.project.restauranttablereservation.models.Reservation;

/**
 * @author sivasaiv
 *
 */
public class RestaurantReservationDto {

	private int id;
	
	private String date;
	
	private String time;
	
	private int guests;
	
	private String name;
	
	private String phoneNumber;
	
	private String status;
	
	private String seatingPreference;
	
	private String smokingPreference;

	public RestaurantReservationDto() {
		
	}
	
	public RestaurantReservationDto(Reservation reservation) {
		this.id = reservation.getId();
		this.date = reservation.getBookingDate().toString();
		this.time = reservation.getSlot().getTime();
		this.guests = reservation.getGuests();
		this.name = reservation.getName();
		this.phoneNumber = reservation.getPhoneNumber();
		this.status= reservation.getStatus().getStatus();
		this.smokingPreference=reservation.getSmokingPreference();
		this.seatingPreference=reservation.getSeatingType().getType();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
}
