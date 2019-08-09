/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.RestaurantPhoneNumber;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantPhoneNumberRepository extends JpaRepository<RestaurantPhoneNumber,Integer> {

}
