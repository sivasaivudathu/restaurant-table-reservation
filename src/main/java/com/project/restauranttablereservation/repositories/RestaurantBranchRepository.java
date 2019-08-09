/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
//@Transactional
public interface RestaurantBranchRepository extends JpaRepository<RestaurantBranch,Integer> {

}
