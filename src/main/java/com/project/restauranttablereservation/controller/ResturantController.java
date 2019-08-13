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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.api.model.AddRestaurantBranchRequest;
import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.AddRestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.service.RestaurantService;

/**
 * @author sivasaiv
 *
 */
@RestController
@RequestMapping("/admin")
public class ResturantController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping(value="/restaurants")
	@ResponseBody
	public BaseResponse addRestaurant(@RequestBody @Valid AddRestaurantRequest request) {
		logger.info("AdminController/addRestaurant...");
		return restaurantService.addRestaurant(request);
	}
	
	@PostMapping("/restaurants/{id}/branches")
	@ResponseBody
	public BaseResponse addRestaurantBranch(@PathVariable int id ,@RequestBody @Valid AddRestaurantBranchRequest request) {
		logger.info("AdminController/addRestaurantBranch...");
		return restaurantService.addRestaurantBranch(id, request.getBranch());
	}

	
	@GetMapping("/restaurants/{id}")
	@ResponseBody
	public AddRestaurantResponse getRestaurant(@PathVariable int id) {
		logger.info("AdminController/getRestaurant...");
		return restaurantService.getRestaurant(id);
	}
	
	@GetMapping("/restaurants")
	@ResponseBody
	public List<RestaurantResponse> getRestaurants(@RequestParam String city){
		logger.info("AdminController/getRestaurants...");
		return restaurantService.getRestaurants(city);
	}
	
	
}
