/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.restauranttablereservation.models.Cuisine;
import com.project.restauranttablereservation.repositories.CuisineRepository;
import com.project.restauranttablereservation.service.CuisineService;

/**
 * @author sivasaiv
 *
 */

@Service
public class CuisineServiceImpl implements CuisineService {

	@Autowired
	CuisineRepository cuisineRepo;

	@Override
	public HashSet<Cuisine> getCuisines(Set<String> cuisines) {

		HashSet<Cuisine> cuisineObjs = new HashSet<>();

		cuisines.forEach(cuisineName -> {
			cuisineName = StringUtils.capitalize(cuisineName.toLowerCase());
			Optional<Cuisine> optionalCuisine = cuisineRepo.findByName(cuisineName);
			if (optionalCuisine.isPresent()) {
				cuisineObjs.add(optionalCuisine.get());
			} else {
				Cuisine cuisine = new Cuisine(cuisineName);
				cuisineObjs.add(cuisine);
			}

		});
		return cuisineObjs;
	}

}
