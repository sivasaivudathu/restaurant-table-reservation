/**
 * 
 */
package com.project.restauranttablereservation.dto;

import java.sql.Date;

import com.project.restauranttablereservation.models.Reservation;

/**
 * @author sivasaiv
 *
 */
public class ReservationDto {

	private String date;
	
	private String time;
	
	private int guests;
	
	private String name;
	
	private String phoneNumber;
	
	private String restaurant;
	
	private String city;
	
	private String address;
	
	private String status;
	
	private Date bookedAt;

	public ReservationDto() {
		
	}
	
	public ReservationDto(Reservation reservation) {
		this.date = reservation.getBookingDate().toString();
		this.time = reservation.getSlot().getTime();
		this.guests = reservation.getGuests();
		this.name = reservation.getName();
		this.phoneNumber = reservation.getPhoneNumber();
		this.restaurant = reservation.getBranch().getRestaurant().getName();
		this.city = reservation.getBranch().getCity();
		this.address = reservation.getBranch().getAddress();
		this.status = reservation.getStatus().getStatus();
		this.bookedAt=reservation.getBookedAt();
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

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(Date bookedAt) {
		this.bookedAt = bookedAt;
	}
	
}
