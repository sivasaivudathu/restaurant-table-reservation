/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import static com.project.restauranttablereservation.util.RestaurantUtils.captalize;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantSlotsResponse;
import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.converters.EntityToDtoConverter;
import com.project.restauranttablereservation.dto.ReservationSlotDto;
import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.exceptions.InvalidInputException;
import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.service.ReservationService;
import com.project.restauranttablereservation.service.ReservationSlotService;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.RestaurantService;


/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestaurantRepository restaurantRepo;

	@Autowired
	RestaurantBranchService branchService;
	
	@Autowired
	EntityToDtoConverter entityConverter;
	
	@Autowired
	ReservationSlotService slotService; 
	
	@Autowired
	ReservationService reservationService;

	@Override
	public RestaurantResponse addRestaurant(@Valid AddRestaurantRequest request){
		logger.info("RestaurantServiceImpl/addRestaurant...");
		RestaurantResponse response = new RestaurantResponse();
		Restaurant restaurantCheck = restaurantRepo.findByName(request.getName());

		if (null != restaurantCheck) {
			response.setMessage("Restauarant Already Exits");
			response.setStatus("FAILURE");
			return response;
		}

		Restaurant restaurant = new Restaurant();
		restaurant.setName(captalize(request.getName()));

		for (RestaurantBranchDetails detail : request.getBranches()) {
			RestaurantBranch branch = branchService.generateBranch(detail);
			restaurant.addBranch(branch);
		}
			restaurant = restaurantRepo.save(restaurant);
			response.setRestaurant(entityConverter.convertRestaurantEntity(restaurant));
			response.setMessage("Restaurant Added SuccessFully");
			response.setStatus("SUCCESS");
		
		return response;
	}

	@Override
	public BaseResponse addRestaurantBranch(int restaurentId, @Valid RestaurantBranchDetails req) {
		logger.info("RestaurantServiceImpl/addRestaurantBranch...");
		BaseResponse response = new BaseResponse();
		RestaurantBranch branch = branchService.generateBranch(req);
			Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(restaurentId);

			if (optionalRestaurant.isPresent()) {
				Restaurant restaurant = optionalRestaurant.get();
				restaurant.addBranch(branch);
				restaurantRepo.save(restaurant);
				response.setStatus("SUCCESS");
				response.setMessage("Branch Added Successfully");
			} else {
				throw new RecordNotFoundException("Invalid Restaurant Id :" +restaurentId);
			}
		
		return response;
	}

	@Override
	public RestaurantResponse getRestaurant(int restaurentId) {
		logger.info("RestaurantServiceImpl/getRestaurant...");
		RestaurantResponse response = new RestaurantResponse();
		Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(restaurentId);

		if (optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			response.setRestaurant(entityConverter.convertRestaurantEntity(restaurant));
			response.setStatus("SUCCESS");
		} else {
			throw new RecordNotFoundException("Invalid Restaurant Id :" +restaurentId);
		}
		return response;
	}

	@Override
	public List<RestaurantDto> getRestaurants() {
		logger.info("RestaurantServiceImpl/getRestaurants...");
		List<RestaurantDto> restaurantsDto ;
			List<Restaurant> restaurants = restaurantRepo.findAll();
			if(restaurants.isEmpty()) {
				throw new RecordNotFoundException("No Restaurants Found");
			}
			restaurantsDto= restaurants.stream().map(entityConverter::convertRestaurantEntity).collect(Collectors.toList());
						
		return restaurantsDto;
	}

	@Override
	public List<RestaurantDto> getRestaurants(String city) {
		List<RestaurantDto> restaurantsDto ;
		if(null == city) {
			return getRestaurants();
		}
		
		List<Restaurant> restaurants =  restaurantRepo.findByBranches_City(city);
		if(restaurants.isEmpty()) {
			
			restaurants = new ArrayList<>();
		}
	
		restaurants.stream().forEach(restaurant -> restaurant.setBranches(restaurant.getBranches().stream()
												.filter(branch -> branch.getCity().equalsIgnoreCase(city)).collect(Collectors.toSet())));
		
		HashSet<Restaurant> restaurantSet = new HashSet<>(restaurants);
		restaurantsDto=	restaurantSet.stream().map(entityConverter::convertRestaurantEntity).collect(Collectors.toList());
		
		
		return restaurantsDto;
	}
	
	public RestaurantSlotsResponse getRestaurantSlots(int branchId,String dateString) {
		Date date;
		try {
		 date = Date.valueOf(dateString);
		}catch(IllegalArgumentException ex) {
			
			throw new InvalidInputException( dateString +" not in yyyy-mm-dd Format");
		}
		Restaurant restaurant = restaurantRepo.findByBranches_Id(branchId);
		if(null == restaurant) {
			throw new RecordNotFoundException("Invalid Branch Id : " +branchId );
		}
		Optional<RestaurantBranch>  optionalBranch = restaurant.getBranches().stream().filter(branch -> branchId==branch.getId()).findFirst();
		RestaurantBranch branch ;
		if(optionalBranch.isPresent()) {
		branch = optionalBranch.get(); 
		}else {
			throw new RecordNotFoundException("Invalid Branch Id : " +branchId );
		}
		
		int capacity = branch.getCapacity();
		Set<ReservationSlot> slots = branch.getSlots();
		Set<ReservationSlotDto> responseSlots = new HashSet<>();
		
		for(ReservationSlot slot : slots) {
			ReservationSlotDto slotDto = new ReservationSlotDto();
			slotDto.setTime(slot.getTime());
			List<Reservation> reservations = reservationService.getReservations(slot, date);
			int totalGuests =0;
			 totalGuests = reservations.stream().map(Reservation::getGuests).collect(Collectors.summingInt(Integer::intValue));
			if(totalGuests < capacity) {
				slotDto.setStatus(SlotStatusType.AVAILABLE);
			}else {
				slotDto.setStatus(SlotStatusType.NOT_AVAILABLE);
			}
			responseSlots.add(slotDto);
		}
		
		HashMap<String, Set<ReservationSlotDto>> data = new HashMap<>();
		data.put(dateString, responseSlots);
		
		return new RestaurantSlotsResponse(branch.getId(), restaurant.getName(), branch.getCity(), branch.getAddress(),data);
	}
	
}
