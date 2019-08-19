/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Restaurant;

/**
 * @author sivasaiv
 *
 */
//@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	Restaurant findByName(String name);
	
	
	List<Restaurant> findByBranches_City(String city);

	Restaurant findByBranches_Id(int id);
}
