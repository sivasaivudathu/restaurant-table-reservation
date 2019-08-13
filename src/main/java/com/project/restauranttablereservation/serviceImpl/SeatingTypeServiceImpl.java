/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import static com.project.restauranttablereservation.util.RestaurantUtils.captalize;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.models.SeatingType;
import com.project.restauranttablereservation.repositories.SeatingTypeRepository;
import com.project.restauranttablereservation.service.SeatingTypeService;

/**
 * @author sivasaiv
 *
 */
@Service
public class SeatingTypeServiceImpl implements SeatingTypeService {

	@Autowired
	SeatingTypeRepository seatingTypeRepo;
	
	@Override
	public HashSet<SeatingType> getSeatingTypes(Set<String> seatingTypes) {

		HashSet<SeatingType> seatingTypeObjs = new HashSet<>();

		seatingTypes.forEach(typeName -> {
			Optional<SeatingType> optionalType = seatingTypeRepo.findByType(captalize(typeName));
			if (optionalType.isPresent()) {
				seatingTypeObjs.add(optionalType.get());
			} else {
				SeatingType paymentType = new SeatingType(typeName);
				seatingTypeObjs.add(paymentType);
			}

		});

		return seatingTypeObjs;
	}

}
