/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Review;

/**
 * @author sivasaiv
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
