/**
 * 
 */
package com.project.restauranttablereservation.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.restauranttablereservation.Dto.RestaurantBranchDto;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
@Component
public class EntityToDtoConverter {

	
	public RestaurantResponse convertRestaurantEntity(Restaurant restaurant) {
		Set<RestaurantBranchDto> brachesDto = restaurant.getBranches().stream().map(RestaurantBranchDto::new).collect(Collectors.toSet());
		return new RestaurantResponse(restaurant.getName(), restaurant.getId(),brachesDto);
	}
	
	public RestaurantBranchDto convertRestaurantBranchEntity(RestaurantBranch branch) {
		
		return new RestaurantBranchDto(branch);
	}
}
