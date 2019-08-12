/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.MenuItem;

/**
 * @author sivasaiv
 *
 */
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
