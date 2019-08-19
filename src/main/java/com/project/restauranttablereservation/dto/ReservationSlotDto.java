/**
 * 
 */
package com.project.restauranttablereservation.dto;

import com.project.restauranttablereservation.constants.SlotStatusType;

/**
 * @author sivasaiv
 *
 */
public class ReservationSlotDto {

	private String time;
	
	private SlotStatusType status;

    private String message;
    
	public ReservationSlotDto() {
		
	}
	
	public ReservationSlotDto(String time, SlotStatusType status) {
		super();
		this.time = time;
		this.status = status;
	}
	
	

	public ReservationSlotDto(String time, SlotStatusType status, String message) {
		super();
		this.time = time;
		this.status = status;
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public SlotStatusType getStatus() {
		return status;
	}

	public void setStatus(SlotStatusType status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
