package com.project.restauranttablereservation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.restauranttablereservation.api.model.AddBranchAdminRequest;
import com.project.restauranttablereservation.api.model.RestaurantSlotsResponse;
import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.dto.RestaurantBranchDto;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.models.RestaurantStatus;
import com.project.restauranttablereservation.repositories.ReservationRepository;
import com.project.restauranttablereservation.repositories.ReservationSlotRepository;
import com.project.restauranttablereservation.repositories.RestaurantBranchRepository;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.repositories.RestaurantStatusRepository;
import com.project.restauranttablereservation.repositories.UsersRepository;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.RestaurantService;
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
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired 
	RestaurantService restService;
	
	@Autowired
	RestaurantBranchService branchService; 
	
	@Autowired
	ReservationSlotRepository slotRepo;
	@Test
	//@Transactional
	public void addRestaurantStatus() {
		
		RestaurantStatus status = new RestaurantStatus(RestaurantStatusType.OPEN);
		
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
	
	ObjectMapper mapper = new ObjectMapper();
	System.out.println(mapper.writeValueAsString(usr));
	 System.out.println(new BCryptPasswordEncoder().matches("12345", usr.getPassword()));
 	}
	
	@Test
	public void getBranch() throws JsonProcessingException {
		
		Optional<RestaurantBranch> branch = branchrepo.findById(5);
		
		ModelMapper modelMapper = new ModelMapper();
		RestaurantBranchDto dto = modelMapper.map(branch.get(), RestaurantBranchDto.class);
		System.out.println("Hi");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(dto));
		
	}
	
	@Test
	public void getRestaurantSlots() throws JsonProcessingException {
		
		RestaurantSlotsResponse rsp =restService.getRestaurantSlots(5, "2018-08-16");
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(rsp));
		
	}
	
	@Test
	public void addBranchAdmin() {
		
		AddBranchAdminRequest req = new AddBranchAdminRequest();
		
		req.setUserid(Arrays.asList(2));
		
		branchService.addRestaurantBranchAdmin(req, 5);
	}
	
	@Test
	public void findbyidandSeating() {
		
		
		RestaurantBranch branch = branchrepo.findByIdAndSeatingTypes_Type(5, "Indoorr");
		System.out.println("HI");
	}
	
	@Test
	public void findByCity() {
		
		List<Restaurant> rest = restRepo.findByBranches_City("Hyderabad");
		HashSet<Restaurant> restSet = new HashSet<Restaurant>(rest);
		System.out.println(restSet.size());
		System.out.println(rest.size());
	}
	
	@Test
	public void checkSlot() {
		
		ReservationSlot slot = slotRepo.findByTimeAndBranch_Id("4:00 pm", 6);
		System.out.println(slot.getId());
	}
	
}
