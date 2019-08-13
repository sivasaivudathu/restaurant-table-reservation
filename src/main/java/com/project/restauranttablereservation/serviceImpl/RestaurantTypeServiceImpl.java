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
import org.springframework.util.StringUtils;

import com.project.restauranttablereservation.models.RestaurantType;
import com.project.restauranttablereservation.repositories.RestaurantTypeRepository;
import com.project.restauranttablereservation.service.RestaurantTypeService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantTypeServiceImpl implements RestaurantTypeService {

	@Autowired
	RestaurantTypeRepository restaurantTypeRepo;
	
	@Override
	public HashSet<RestaurantType> getRestaurantTypes(Set<String> restaurantTypes) {

		HashSet<RestaurantType> restaurantTypeObjs = new HashSet<>();

		restaurantTypes.forEach(typeName -> {
			Optional<RestaurantType> optionalType = restaurantTypeRepo.findByType(captalize(typeName));
			if (optionalType.isPresent()) {
				restaurantTypeObjs.add(optionalType.get());
			} else {
				RestaurantType restaurantType = new RestaurantType(typeName);
				restaurantTypeObjs.add(restaurantType);
			}

		});

		return restaurantTypeObjs;
	}

}
