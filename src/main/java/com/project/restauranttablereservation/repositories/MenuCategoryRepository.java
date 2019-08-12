/**
 * 
 */
package com.project.restauranttablereservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.MenuCategory;

/**
 * @author sivasaiv
 *
 */
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {

}
