/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.repositories.RoleRepository;
import com.project.restauranttablereservation.repositories.UsersRepository;
import com.project.restauranttablereservation.service.CustomerService;

/**
 * @author sivasaiv
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
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
			user.addRole(roleRepo.findRoleByRoleName("USER"));
			user.setActive(true);
			user =userRepo.save(user);
			response.setStatus("SUCCESS");
			response.setMessage("User created SucessFully");
		
			return response;
	}
}
