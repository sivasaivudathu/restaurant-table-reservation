/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.RestaurantStatus;
import com.project.restauranttablereservation.repositories.RestaurantStatusRepository;
import com.project.restauranttablereservation.service.RestaurantStatusService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantStatusServiceImpl implements RestaurantStatusService {

	@Autowired
	RestaurantStatusRepository statusRepository;
	
	@Override
	public RestaurantStatus getRestaurantStatus(RestaurantStatusType type) {
		
		RestaurantStatus status = statusRepository.findByStatus(type);
		
		if(null == status) {
			status = new RestaurantStatus(type);
		}
		
		return status;
	}

	

	

}
