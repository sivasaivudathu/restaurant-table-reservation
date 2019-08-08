/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sivasaiv
 *
 */
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	
	
	
}
