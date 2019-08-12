/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.RestaurantType;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Integer> {
	
	public Optional<RestaurantType> findByType(String type);

}
