/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.PaymentType;

/**
 * @author sivasaiv
 *
 */
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{
	
	public Optional<PaymentType> findByType(String type);

}
