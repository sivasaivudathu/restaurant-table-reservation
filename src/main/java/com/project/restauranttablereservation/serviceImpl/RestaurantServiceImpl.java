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
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.AddRestaurantRequest;
import com.project.restauranttablereservation.api.model.RestaurantBranchDetails;
import com.project.restauranttablereservation.api.model.RestaurantReservationsResponse;
import com.project.restauranttablereservation.api.model.RestaurantResponse;
import com.project.restauranttablereservation.api.model.RestaurantSlotsResponse;
import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.converters.EntityToDtoConverter;
import com.project.restauranttablereservation.dto.ReservationSlotDto;
import com.project.restauranttablereservation.dto.RestaurantDto;
import com.project.restauranttablereservation.dto.RestaurantReservationDto;
import com.project.restauranttablereservation.exceptions.InvalidInputException;
import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.ReservationStatus;
import com.project.restauranttablereservation.models.Restaurant;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.repositories.RestaurantRepository;
import com.project.restauranttablereservation.service.ReservationService;
import com.project.restauranttablereservation.service.ReservationSlotService;
import com.project.restauranttablereservation.service.ReservationStatusService;
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
	
	@Autowired
	ReservationStatusService statusService;

	@Override
	public RestaurantResponse addRestaurant(AddRestaurantRequest request) {
		logger.info("RestaurantServiceImpl/addRestaurant...");
		RestaurantResponse response = new RestaurantResponse();

		if (isRestaurantExits(request.getName())) {
			response.setMessage("Restauarant Already Exits");
			response.setStatus("FAILURE");
			return response;
		}

		Restaurant restaurant = getRestaurantEntity(request);
		restaurant = restaurantRepo.save(restaurant);

		response.setRestaurant(getRestaurantDTO(restaurant));
		response.setMessage("Restaurant Added SuccessFully");
		response.setStatus("SUCCESS");

		return response;
	}

	private RestaurantDto getRestaurantDTO(Restaurant restaurant) {
		return entityConverter.convertRestaurantEntity(restaurant);
	}

	private Restaurant getRestaurantEntity(AddRestaurantRequest request) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(captalize(request.getName()));

		for (RestaurantBranchDetails detail : request.getBranches()) {
			RestaurantBranch branch = getRestaurantBranchEntity(detail);
			restaurant.addBranch(branch);
		}
		return restaurant;
	}

	private RestaurantBranch getRestaurantBranchEntity(RestaurantBranchDetails detail) {
		return branchService.generateBranch(detail);
	}

	private boolean isRestaurantExits(String restaurantName) {
		Restaurant restaurant = restaurantRepo.findByName(restaurantName);

		return !isRestaurantNull(restaurant) ;
	}

	private boolean isRestaurantNull(Restaurant restaurant) {

		return Objects.isNull(restaurant);
	}

	@Override
	public BaseResponse addRestaurantBranch(int restaurantId, RestaurantBranchDetails req) {
		logger.info("RestaurantServiceImpl/addRestaurantBranch...");
		BaseResponse response = new BaseResponse();

		if (!isRestaurantExists(restaurantId)) {
			throw new RecordNotFoundException("Invalid Restaurant Id :" + restaurantId);
		}

		Optional<Restaurant> optionalRestaurant = getRestaurantById(restaurantId);
		Restaurant restaurant = optionalRestaurant.get();

		RestaurantBranch branch = getRestaurantBranchEntity(req);

		restaurant.addBranch(branch);
		restaurantRepo.save(restaurant);

		response.setStatus("SUCCESS");
		response.setMessage("Branch Added Successfully");

		return response;
	}

	private Optional<Restaurant> getRestaurantById(int restaurantId) {
		return restaurantRepo.findById(restaurantId);
	}

	private boolean isRestaurantExists(int restaurantId) {

		Optional<Restaurant> optionalRestaurant = getRestaurantById(restaurantId);

		return optionalRestaurant.isPresent();
	}

	@Override
	public RestaurantResponse getRestaurant(int restaurentId) {
		logger.info("RestaurantServiceImpl/getRestaurant...");
		RestaurantResponse response = new RestaurantResponse();
		Optional<Restaurant> optionalRestaurant = getRestaurantById(restaurentId);

		if (optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			response.setRestaurant(getRestaurantDTO(restaurant));
			response.setStatus("SUCCESS");
		} else {
			throw new RecordNotFoundException("Invalid Restaurant Id :" + restaurentId);
		}
		return response;
	}

	@Override
	public List<RestaurantDto> getRestaurants() {
		logger.info("RestaurantServiceImpl/getRestaurants...");
		List<RestaurantDto> restaurantsDto;
		List<Restaurant> restaurants = restaurantRepo.findAll();
		if (restaurants.isEmpty()) {
			throw new RecordNotFoundException("No Restaurants Found");
		}
		restaurantsDto = restaurants.stream().map(entityConverter::convertRestaurantEntity)
				.collect(Collectors.toList());

		return restaurantsDto;
	}

	@Override
	public List<RestaurantDto> getRestaurants(String city) {
		List<RestaurantDto> restaurantsDto;
		if (null == city) {
			return getRestaurants();
		}
		
		List<Restaurant> restaurants = restaurantRepo.findByBranches_City(city);
		if (restaurants.isEmpty()) {
			return new ArrayList<>();
		}

		filterRestaurantsByCity(city, restaurants);

		HashSet<Restaurant> restaurantSet = new HashSet<>(restaurants);
		restaurantsDto = restaurantSet.stream().map(this::getRestaurantDTO).collect(Collectors.toList());

		return restaurantsDto;
	}

	private void filterRestaurantsByCity(String city, List<Restaurant> restaurants) {
		restaurants.stream().forEach(restaurant -> restaurant.setBranches(restaurant.getBranches().stream()
				.filter(branch -> branch.getCity().equalsIgnoreCase(city)).collect(Collectors.toSet())));
	}

	public RestaurantSlotsResponse getRestaurantSlots(int branchId, String dateString) {

		if (isBranchIdNull(branchId)) {
			throw new InvalidInputException("BranchId cannot be Null");
		}
		RestaurantBranch branch = getRestaurantBranch(branchId);

		Set<ReservationSlot> reservationSlots = branch.getSlots();
		Set<ReservationSlotDto> responseSlots = new HashSet<>();
		int capacity = branch.getCapacity();

		for (ReservationSlot slot : reservationSlots) {
			ReservationSlotDto slotDto = new ReservationSlotDto();
			List<Reservation> reservations = getReservations(slot, getDatefromString(dateString));
			setSlotAvailability(capacity, slotDto, reservations);
			slotDto.setTime(slot.getTime());
			responseSlots.add(slotDto);
		}

		HashMap<String, Set<ReservationSlotDto>> data = new HashMap<>();
		data.put(dateString, responseSlots);

		return new RestaurantSlotsResponse(branch.getId(), branch.getRestaurant().getName(), branch.getCity(),
				branch.getAddress(), data);
	}
	
	@Override
	public RestaurantReservationsResponse getBranchReservations(int branchId) {
		
		if(isBranchIdNull(branchId)) {
			throw new InvalidInputException("BranchId cannot be Null");
		}
		
		List<Reservation> reservations = getReservationsByBranchId(branchId);
		List<RestaurantReservationDto> reservationsDto = reservations.stream().map(RestaurantReservationDto::new).collect(Collectors.toList());
		return new RestaurantReservationsResponse(reservationsDto);
	}
	
	public BaseResponse updateReservationStatus(int reservationId,String status) {
		
		reservationService.updateReservationStatus(reservationId, status);
		
		return new BaseResponse("SUCCESS", "Reservation Status Updated Successfully");
	}

	private void setSlotAvailability(int capacity, ReservationSlotDto slotDto, List<Reservation> reservations) {
		int totalGuests = 0;
		totalGuests = reservations.stream().map(Reservation::getGuests)
				.collect(Collectors.summingInt(Integer::intValue));
		if (totalGuests < capacity) {
			slotDto.setStatus(SlotStatusType.AVAILABLE);
		} else {
			slotDto.setStatus(SlotStatusType.NOT_AVAILABLE);
		}
	}
	
	private List<Reservation> getReservationsByBranchId(int branchId){
		return reservationService.getBranchReservations(branchId);
	}
	private List<Reservation> getReservations(ReservationSlot slot, Date date) {
		return reservationService.getReservations(slot, date);
	}

	private RestaurantBranch getRestaurantBranch(int branchId) {
		return branchService.getBranchById(branchId);
	}

	private Date getDatefromString(String dateString) {
		Date date;
		try {
			date = Date.valueOf(dateString);
		} catch (IllegalArgumentException ex) {
			throw new InvalidInputException(dateString + " not in yyyy-mm-dd Format");
		}
		return date;
	}

	private boolean isBranchIdNull(int branchId) {
		return Objects.isNull(branchId);
	}

	
}
