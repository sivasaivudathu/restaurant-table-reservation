/**
 * 
 */
package com.project.restauranttablereservation.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.restauranttablereservation.dto.ReservationDto;
import com.project.restauranttablereservation.dto.RestaurantBranchDto;
import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;

/**
 * @author sivasaiv
 *
 */
@Component
public class EntityToDtoConverter {

	
	public RestaurantDto convertRestaurantEntity(Restaurant restaurant) {
		Set<RestaurantBranchDto> brachesDto = restaurant.getBranches().stream().map(RestaurantBranchDto::new).collect(Collectors.toSet());
		return new RestaurantDto(restaurant.getName(), restaurant.getId(),brachesDto);
	}
	
	public RestaurantBranchDto convertRestaurantBranchEntity(RestaurantBranch branch) {
		
		return new RestaurantBranchDto(branch);
	}
	
	public ReservationDto convertReservationEntity(Reservation reservation) {
		
		return new ReservationDto(reservation);
	}
}
