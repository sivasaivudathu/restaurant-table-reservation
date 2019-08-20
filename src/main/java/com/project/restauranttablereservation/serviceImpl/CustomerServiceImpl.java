/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.UserReservationsResponse;
import com.project.restauranttablereservation.dto.ReservationDto;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.repositories.RoleRepository;
import com.project.restauranttablereservation.repositories.UsersRepository;
import com.project.restauranttablereservation.service.CustomerService;
import com.project.restauranttablereservation.service.ReservationService;
import com.project.restauranttablereservation.service.RoleService;

/**
 * @author sivasaiv
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ReservationService reservationService;
	
	@Override
	public BaseResponse addUser(User user) {
		
		BaseResponse response = new BaseResponse();
		
		Optional<User> usercheck = userRepo.findByName(user.getName());
		
		if(usercheck.isPresent()) {
			response.setStatus("FAILURE");
			response.setMessage("User Already Exists");
			return response;
		}
			String encryptedpass = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encryptedpass);
			user.addRole(roleService.getRole("USER"));
			user.setActive(true);
			userRepo.save(user);
			response.setStatus("SUCCESS");
			response.setMessage("User created SucessFully");
		
			return response;
	}
	
	public UserReservationsResponse getReservations(int userId) {
		
		List<Reservation> reservations = reservationService.getUserReservations(userId);
		List<ReservationDto> reservationsDto = reservations.stream().map(ReservationDto :: new).collect(Collectors.toList());
		return new UserReservationsResponse(reservationsDto);
				
	}
}
