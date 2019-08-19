/**
 * 
 */
package com.project.restauranttablereservation.api.model;

import java.util.Map;
import java.util.Set;

import com.project.restauranttablereservation.dto.ReservationSlotDto;
import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public class RestaurantSlotsResponse extends BaseResponse {

	private int branchId;
	
	private String name;
	
	private String city;
	
	private String address;
	
	private Map<String,Set<ReservationSlotDto>> data;
	
	
	public RestaurantSlotsResponse() {
		
	}


	public RestaurantSlotsResponse(int branchId, String name, String city, String address,
			Map<String, Set<ReservationSlotDto>> data) {
		super();
		this.branchId = branchId;
		this.name = name;
		this.city = city;
		this.address = address;
		this.data = data;
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


	public Map<String, Set<ReservationSlotDto>> getData() {
		return data;
	}


	public void setData(Map<String, Set<ReservationSlotDto>> data) {
		this.data = data;
	}

	
}
