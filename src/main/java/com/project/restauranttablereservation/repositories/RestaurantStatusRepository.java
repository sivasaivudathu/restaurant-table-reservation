/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.RestaurantStatus;

/**
 * @author sivasaiv
 *
 */
//@Transactional
public interface RestaurantStatusRepository extends JpaRepository<RestaurantStatus,Integer> {

	RestaurantStatus findByStatus(RestaurantStatusType statusType);
}
