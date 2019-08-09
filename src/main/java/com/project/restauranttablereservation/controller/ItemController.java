package com.project.restauranttablereservation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restauranttablereservation.constants.RestaurantStatusType;
import com.project.restauranttablereservation.models.Item;
import com.project.restauranttablereservation.models.RestaurantPhoneNumber;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.repositories.RestaurantBranchRepository;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.repositories.RestaurantStatusRepository;

@RestController
public class ItemController {

    @Autowired
    ItemController itemService;
    
    @Autowired
	RestaurantStatusRepository repo;
	
	@Autowired
	RestaurantBranchRepository branchrepo;
	
	@Autowired
	RestaurantRepository restRepo;

    public static List<Item> items;
    static{
        items = new ArrayList<>(Arrays.asList(new Item(1,"Spring Boot in Action","Books"),
                new Item(2,"Java 8 in Action","Books"),
                new Item(3,"Data Structures","Books"),
                new Item(4,"Spring Boot Security","Books")));
    }

   
    @RequestMapping("/getAllItems")
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = this.items;
        System.out.println("Reading items: "+items);
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello User!";
    }

    @RequestMapping("/restaurant")
    public void addrest() {
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
    
    
    
}
