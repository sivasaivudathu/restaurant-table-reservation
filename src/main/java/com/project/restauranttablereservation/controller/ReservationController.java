/**
 * 
 */
package com.project.restauranttablereservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.api.model.ReservationRequest;
import com.project.restauranttablereservation.api.model.UserReservationsResponse;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.service.ReservationService;

/**
 * @author sivasaiv
 *
 */
@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/reservations")
	@ResponseBody
	public BaseResponse addReservation(@RequestBody ReservationRequest request) {
		
		return reservationService.addReservation(request);
	}
	
	
	  @GetMapping("/reservations")
	  @ResponseBody 
	  public UserReservationsResponse getReservations(@RequestParam int id) {
		  return reservationService.getUserReservations(id);
	  }
	 
	  
	  
}
