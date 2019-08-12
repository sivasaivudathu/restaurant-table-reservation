/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.restauranttablereservation.constants.SlotStatusType;

/**
 * @author sivasaiv
 *
 */

@Entity
@Table(name = "slot_status")
public class SlotStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private SlotStatusType status;

	public SlotStatus() {
		
	}
	
	public SlotStatus(SlotStatusType status) {
		super();
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SlotStatusType getStatus() {
		return status;
	}

	public void setStatus(SlotStatusType status) {
		this.status = status;
	}
	
	
}
