/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import static com.project.restauranttablereservation.util.RestaurantUtils.captalize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.AddRestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.converters.EntityToDtoConverter;
import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.RestaurantService;


/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestaurantRepository restaurantRepo;

	@Autowired
	RestaurantBranchService branchService;
	
	@Autowired
	EntityToDtoConverter entityConverter;

	@Override
	public AddRestaurantResponse addRestaurant(AddRestaurantRequest request) {
		logger.info("RestaurantServiceImpl/addRestaurant...");
		AddRestaurantResponse response = new AddRestaurantResponse();
		Restaurant restaurantCheck = restaurantRepo.findByName(request.getName());

		if (null != restaurantCheck) {
			response.setMessage("Restauarant Already Exits");
			response.setStatus("FAILURE");
			return response;
		}

		Restaurant restaurant = new Restaurant();
		restaurant.setName(captalize(request.getName()));

		for (RestaurantBranchDetails detail : request.getBranches()) {
			RestaurantBranch branch = branchService.generateBranch(detail);
			restaurant.addBranch(branch);
		}
		try {
			restaurant = restaurantRepo.save(restaurant);
			
			response.setRestaurant(entityConverter.convertRestaurantEntity(restaurant));
			
			response.setMessage("Restaurant Added SuccessFully");
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public BaseResponse addRestaurantBranch(int restaurentId, RestaurantBranchDetails req) {
		logger.info("RestaurantServiceImpl/addRestaurantBranch...");
		BaseResponse response = new BaseResponse();
		RestaurantBranch branch = branchService.generateBranch(req);
		try {
			Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(restaurentId);

			if (optionalRestaurant.isPresent()) {
				Restaurant restaurant = optionalRestaurant.get();
				restaurant.addBranch(branch);
				restaurant = restaurantRepo.save(restaurant);
				response.setStatus("SUCCESS");
				response.setMessage("Branch Added Successfully");
			} else {
				throw new RecordNotFoundException("Invalid Restaurant Id :" +restaurentId);
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public AddRestaurantResponse getRestaurant(int restaurentId) {
		logger.info("RestaurantServiceImpl/getRestaurant...");
		AddRestaurantResponse response = new AddRestaurantResponse();
		Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(restaurentId);

		if (optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			response.setRestaurant(entityConverter.convertRestaurantEntity(restaurant));
			response.setStatus("SUCCESS");
		} else {
			throw new RecordNotFoundException("Invalid Restaurant Id :" +restaurentId);
		}
		return response;
	}

	@Override
	public List<RestaurantResponse> getRestaurants() {
		logger.info("RestaurantServiceImpl/getRestaurants...");
		List<RestaurantResponse> restaurantsResponse = new ArrayList<>();
		try {
			List<Restaurant> restaurants = restaurantRepo.findAll();
			if(restaurants.isEmpty()) {
				throw new RecordNotFoundException("No Restaurants Found");
			}
			restaurantsResponse=	restaurants.stream().map(entityConverter::convertRestaurantEntity).collect(Collectors.toList());
						
		} catch (Exception e) {
			throw e;
		}
		return restaurantsResponse;
	}

	@Override
	public List<RestaurantResponse> getRestaurants(String city) {
		List<RestaurantResponse> restaurantsResponse = new ArrayList<>();
		if(null == city) {
			return getRestaurants();
		}
		try {
		List<Restaurant> restaurants =  restaurantRepo.findByBranches_City(city);
		if(restaurants.isEmpty()) {
			throw new RecordNotFoundException("Invalid City Name : " +city );
		}
		restaurantsResponse=	restaurants.stream().map(entityConverter::convertRestaurantEntity).collect(Collectors.toList());
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return restaurantsResponse;
	}
}
