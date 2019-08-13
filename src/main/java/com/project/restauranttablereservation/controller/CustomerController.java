/**
 * 
 */
package com.project.restauranttablereservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.service.CustomerService;

/**
 * @author sivasaiv
 *
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/user/signup")
	@ResponseBody
	public BaseResponse adduser(@RequestBody User user) {
		return customerService.addUser(user);
	}
}
