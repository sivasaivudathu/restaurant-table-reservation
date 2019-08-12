/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.request.model.AddRestaurantBranchRequest;
import com.project.restauranttablereservation.service.RestaurantService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepo;

	@Autowired
	RestaurantServiceHelper serviceHelper;

	@Override
	public BaseResponse addRestaurant(Restaurant restaurant) {
		BaseResponse response = new BaseResponse();
		Restaurant restaurantCheck = restaurantRepo.findByName(restaurant.getName());

		if (null != restaurantCheck) {
			response.setMessage("Restauarant Already Exits");
			response.setStatus("FAILURE");
			return response;
		}

		restaurant = restaurantRepo.save(restaurant);
		if (null == restaurant) {
			response.setMessage("Error Ocuured");
			response.setStatus("FAILURE");
		} else {
			response.setMessage("Restaurant Added SuccessFully");
			response.setStatus("SUCCESS");
		}

		return response;
	}

	@Override
	public BaseResponse addRestaurantBranch(int restaurentId, AddRestaurantBranchRequest req) {

		BaseResponse response = new BaseResponse();
		RestaurantBranch branch = new RestaurantBranch();

		branch.setAddress(req.getAddress());
		branch.setCapacity(req.getCapacity());
		branch.setCity(req.getCity());
		branch.setClosesAt(req.getClosesAt());
		branch.setOpensAt(req.getOpensAt());

		if (!req.getCuisines().isEmpty()) {
			branch.setCuisines(serviceHelper.getCuisines(req.getCuisines()));
		}

		if (!req.getPaymentTypes().isEmpty()) {
			branch.setPaymentTypes(serviceHelper.getPaymentTypes(req.getPaymentTypes()));
		}

		if (!req.getRestauranttype().isEmpty()) {
			branch.setTypes(serviceHelper.getRestaurantTypes(req.getRestauranttype()));
		}

		if (!req.getSeating().isEmpty()) {
			branch.setSeatingTypes(serviceHelper.getSeatingTypes(req.getSeating()));
		}
		
		if(!req.getSlots().isEmpty()) {
			branch.setSlots(serviceHelper.getReservationSlots(req.getSlots()));
		}

		if(!req.getPhone().isEmpty()) {
			branch.setPhone(serviceHelper.getPhoneNumbers(req.getPhone()));
		}
		
		Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(restaurentId);
		
		if(optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			restaurant.addBranch(branch);
			restaurant = restaurantRepo.save(restaurant);
			response.setStatus("SUCCESS");
			response.setMessage("Branch Added Successfully");
		}else {
			
			response.setStatus("FAILED");
			response.setMessage("Restaurant doesn't exists with given Id");
		}
		return response;
	}
	
}
