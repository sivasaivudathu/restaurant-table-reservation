/**
 * 
 */
package com.project.restauranttablereservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.request.model.AddRestaurantBranchRequest;
import com.project.restauranttablereservation.service.RestaurantService;

/**
 * @author sivasaiv
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping(value="/restaurant")
	@ResponseBody
	public BaseResponse addRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.addRestaurant(restaurant);
	}
	
	@PostMapping("/restaurant/{id}/branch")
	@ResponseBody
	public BaseResponse addRestaurantBranch(@PathVariable int id ,@RequestBody AddRestaurantBranchRequest request) {
		
		return restaurantService.addRestaurantBranch(id, request);
	}
}
