/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.RestaurantStatus;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantStatusRepository extends JpaRepository<RestaurantStatus,Integer> {

}
