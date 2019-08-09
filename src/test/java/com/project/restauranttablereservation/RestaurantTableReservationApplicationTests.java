package com.project.restauranttablereservation;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.models.RestaurantPhoneNumber;
import com.project.restauranttablereservation.models.RestaurantStatus;
import com.project.restauranttablereservation.repositories.RestaurantBranchRepository;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.repositories.RestaurantStatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantTableReservationApplicationTests {

	
	@Autowired
	RestaurantStatusRepository repo;
	
	@Autowired
	RestaurantBranchRepository branchrepo;
	
	@Autowired
	RestaurantRepository restRepo;
	
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

	@Transactional
	public void addRestaurantBranch() {

		
		  RestaurantBranch branch = new RestaurantBranch();
		  
		  branch.setAddress("Road No.1 , Banjara Hills"); branch.setCapacity(50);
		  branch.setCity("Hyderabad"); branch.setClosesAt("11 pm");
		  branch.setOpensAt("4 pm");
		  
		  branch.setStatus(repo.findByStatus(RestaurantStatusType.OPEN));
		  
		  RestaurantPhoneNumber ph = new RestaurantPhoneNumber(); 
		  
		  ph.setNumber("999999999");
		  ph.setType("Cell");
		 
		  
		 
		  Restaurant restaurant = new Restaurant();
		  restaurant.setName("RAGHAV");
		  
		  restRepo.save(restaurant);

	}
	 
	@Test
	public void getAllrest() {
		
		List<Restaurant> r = restRepo.findAll();
		System.out.println(r.size());
	}
}
