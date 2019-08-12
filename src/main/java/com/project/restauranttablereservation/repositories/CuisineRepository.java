/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Cuisine;

/**
 * @author sivasaiv
 *
 */
public interface CuisineRepository extends JpaRepository<Cuisine, Integer> {
	
	
	public Optional<Cuisine> findByName(String cuisineName);

}
