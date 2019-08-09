/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Restaurant;

/**
 * @author sivasaiv
 *
 */
//@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	Restaurant findByName(String name);

}
