package com.project.restauranttablereservation;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.RestaurantStatus;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.repositories.RestaurantBranchRepository;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.repositories.RestaurantStatusRepository;
import com.project.restauranttablereservation.repositories.UsersRepository;
import com.project.restauranttablereservation.serviceImpl.UserDetailsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantTableReservationApplicationTests {

	
	@Autowired
	RestaurantStatusRepository repo;
	
	@Autowired
	RestaurantBranchRepository branchrepo;
	
	@Autowired
	RestaurantRepository restRepo;
	
	@Autowired
	UsersRepository userrepo;
	
	@Autowired
	UserDetailsServiceImpl service;
	
	@Test
	//@Transactional
	public void addRestaurantStatus() {
		
		RestaurantStatus status = new RestaurantStatus(0, RestaurantStatusType.OPEN);
		
		repo.save(status);
	}

	@Test
	public void findRestaurantStatusByType() {
		
		RestaurantStatus status = repo.findByStatus(RestaurantStatusType.OPEN);
		System.out.println("HI");
	}
	
	@Test
	public void getUserByName() throws JsonProcessingException {
		
	UserDetails usr = service.loadUserByUsername("SIVA");
	//User user = usr.get();
	//System.out.println(user.getName());
	ObjectMapper mapper = new ObjectMapper();
	System.out.println(mapper.writeValueAsString(usr));
	 System.out.println(new BCryptPasswordEncoder().matches("12345", usr.getPassword()));
 	}
	
}
