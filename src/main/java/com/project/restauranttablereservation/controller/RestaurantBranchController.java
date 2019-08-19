/**
 * 
 */
package com.project.restauranttablereservation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.api.model.AddBranchAdminRequest;

/**
 * @author sivasaiv
 *
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantBranchController {

	@PostMapping("/branches/{id}")
	@ResponseBody
	public void addBranchAdmin(@RequestBody AddBranchAdminRequest request,@PathVariable int branchId) {
		
	}
}
