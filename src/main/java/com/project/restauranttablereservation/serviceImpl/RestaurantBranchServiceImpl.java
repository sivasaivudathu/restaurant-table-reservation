/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;
import static com.project.restauranttablereservation.util.RestaurantUtils.captalize;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.AddBranchAdminRequest;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.repositories.RestaurantBranchRepository;
import com.project.restauranttablereservation.service.CuisineService;
import com.project.restauranttablereservation.service.PaymentTypeService;
import com.project.restauranttablereservation.service.ReservationSlotService;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.RestaurantPhoneNumberService;
import com.project.restauranttablereservation.service.RestaurantStatusService;
import com.project.restauranttablereservation.service.RestaurantTypeService;
import com.project.restauranttablereservation.service.RoleService;
import com.project.restauranttablereservation.service.SeatingTypeService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantBranchServiceImpl implements RestaurantBranchService {

	@Autowired
	CuisineService cuisineService;
	
	@Autowired 
	PaymentTypeService paymentTypeService;
	
	@Autowired
	RestaurantTypeService restaurantTypeService;
	
	@Autowired
	SeatingTypeService seatingTypeService;
	
	@Autowired
	RestaurantPhoneNumberService phoneNumberService;
	
	@Autowired
	ReservationSlotService reservationSlotService;
	
	@Autowired
	RestaurantStatusService restStatusService;
	
	@Autowired
	RestaurantBranchRepository branchRepository;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public RestaurantBranch generateBranch(RestaurantBranchDetails details) {
		RestaurantBranch branch = new RestaurantBranch();
		try {
		branch.setAddress(details.getAddress());
		branch.setCapacity(details.getCapacity());
		branch.setCity(captalize(details.getCity()));
		branch.setClosesAt(details.getClosesAt());
		branch.setOpensAt(details.getOpensAt());
		
		if(null != details.getStatus()) {
		branch.setStatus(restStatusService.getRestaurantStatus(Enum.valueOf(RestaurantStatusType.class, details.getStatus().toUpperCase())));
		}
		if (!details.getCuisines().isEmpty()) {
			branch.setCuisines(cuisineService.getCuisines(details.getCuisines()));
		}

		if (!details.getPaymentTypes().isEmpty()) {
			branch.setPaymentTypes(paymentTypeService.getPaymentTypes(details.getPaymentTypes()));
		}

		if (!details.getRestauranttype().isEmpty()) {
			branch.setTypes(restaurantTypeService.getRestaurantTypes(details.getRestauranttype()));
		}

		if (!details.getSeating().isEmpty()) {
			branch.setSeatingTypes(seatingTypeService.getSeatingTypes(details.getSeating()));
		}
		
		if(!details.getSlots().isEmpty()) {
			branch.setSlots(reservationSlotService.getReservationSlots(details.getSlots()));
		}

		if(!details.getPhone().isEmpty()) {
			branch.setPhone(phoneNumberService.getPhoneNumbers(details.getPhone()));
		}
		}catch(IllegalArgumentException e) {
			throw new RecordNotFoundException("Invalid Restaurant Status : " +details.getStatus());
		}catch(Exception e) {
			throw e;
		}
		return branch;
	}

	@Override
	public void addRestaurantBranchAdmin(AddBranchAdminRequest request, int branchId) {
		
		Optional<RestaurantBranch> optionalBranch = branchRepository.findById(branchId);
		
		if(!optionalBranch.isPresent()) {
			throw new RecordNotFoundException("Restaurant Branch doesn't exits with id :"+branchId);
		}
		Set<User> users = request.getUserid().stream().map(id ->{
			     User user=  userDetailsService.getUserById(id);
			     user.addRole(roleService.getRole("RESTAURANT_ADMIN"));
			     return user;
			     }).collect(Collectors.toSet());
		
		RestaurantBranch branch = optionalBranch.get();
		branch.addAdminUsers(users);
		branchRepository.save(branch);
	}

	@Override
	public RestaurantBranch getBranchById(int branchId) {
	    	
	    	Optional<RestaurantBranch> optionalUser = branchRepository.findById(branchId);
	    	if(!optionalUser.isPresent()) {
	    		throw new RecordNotFoundException("Restaurant Branch not found with Id :"+branchId);
	    	}
	    	
	    	return optionalUser.get();
	    }
	
}
