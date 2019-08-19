/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sivasaiv
 *
 */

@Entity
@Table(name = "reservation_slot")
public class ReservationSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slot_id")
	private int id;
	
	@Column(name = "slot_time")
	private String time;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional=false)
	@JoinColumn(name ="status_id")
	private SlotStatus status;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private RestaurantBranch branch;
	
	public ReservationSlot() {
		
	}

	
	public ReservationSlot(String time, SlotStatus status) {
		super();
		this.time = time;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}

	
	
}
