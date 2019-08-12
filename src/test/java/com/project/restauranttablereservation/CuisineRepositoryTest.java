/**
 * 
 */
package com.project.restauranttablereservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.restauranttablereservation.models.Cuisine;
import com.project.restauranttablereservation.repositories.CuisineRepository;

/**
 * @author sivasaiv
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CuisineRepositoryTest {

	@Autowired
	CuisineRepository cuisineRepo;
	
	@Test
	public void addCuisines() {
		
		Cuisine cuisine = new Cuisine();
		cuisine.setName("European");
		
		cuisineRepo.save(cuisine);
		
	}

}
