/**
 * 
 */
package com.project.restauranttablereservation.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.api.model.AddRestaurantBranchRequest;
import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantSlotsResponse;
import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.service.RestaurantService;

/**
 * @author sivasaiv
 *
 */
@RestController
public class ResturantController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping(value="/restaurants")
	@ResponseBody
	public RestaurantResponse addRestaurant(@Valid @RequestBody  AddRestaurantRequest request) {
		logger.info("ResturantController/addRestaurant...");
		return restaurantService.addRestaurant(request);
	}
	
	@PostMapping("/restaurants/{id}/branches")
	@ResponseBody
	public BaseResponse addRestaurantBranch(@PathVariable int id ,@RequestBody @Valid AddRestaurantBranchRequest request) {
		logger.info("ResturantController/addRestaurantBranch...");
		return restaurantService.addRestaurantBranch(id, request.getBranch());
	}

	
	@GetMapping("/restaurants/{id}")
	@ResponseBody
	public RestaurantResponse getRestaurant(@PathVariable int id) {
		logger.info("ResturantController/getRestaurant...");
		return restaurantService.getRestaurant(id);
	}
	
	@GetMapping("/restaurants")
	@ResponseBody
	public List<RestaurantDto> getRestaurants(@RequestParam(required =false) String city){
		logger.info("ResturantController/getRestaurants...");
		return restaurantService.getRestaurants(city);
	}
	
	@GetMapping("/restaurant/{branchId}/slots")
	@ResponseBody
	public RestaurantSlotsResponse getRestaurantSlots(@PathVariable  int branchId,@RequestParam String date) {
		logger.info("ResturantController/getRestaurantSlots...");
		return restaurantService.getRestaurantSlots(branchId, date);
	}
}
