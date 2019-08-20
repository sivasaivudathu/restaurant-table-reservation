/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.ReservationRequest;
import com.project.restauranttablereservation.api.model.UserReservationsResponse;
import com.project.restauranttablereservation.converters.EntityToDtoConverter;
import com.project.restauranttablereservation.dto.ReservationDto;
import com.project.restauranttablereservation.exceptions.InvalidInputException;
import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.ReservationStatus;
import com.project.restauranttablereservation.models.RestaurantBranch;
import com.project.restauranttablereservation.models.SeatingType;
import com.project.restauranttablereservation.models.User;
import com.project.restauranttablereservation.repositories.ReservationRepository;
import com.project.restauranttablereservation.service.ReservationService;
import com.project.restauranttablereservation.service.ReservationSlotService;
import com.project.restauranttablereservation.service.ReservationStatusService;
import com.project.restauranttablereservation.service.RestaurantBranchService;
import com.project.restauranttablereservation.service.SeatingTypeService;

/**
 * @author sivasaiv
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	UserDetailsServiceImpl userService;
	
	@Autowired
	RestaurantBranchService branchService;
	
	@Autowired
	ReservationSlotService slotService;
	
	@Autowired
	SeatingTypeService seatingTypeService;
	
	@Autowired
	ReservationStatusService statusService;
	
	@Autowired
	EntityToDtoConverter dtoConverter;

	@Override
	public List<Reservation> getReservations(ReservationSlot slot, Date date) {
		
		return reservationRepo.findBySlotAndBookingDate(slot, date);
	}


	@Override
	public BaseResponse addReservation(ReservationRequest reservationRequest) {
		
		Reservation reservation = getReservation(reservationRequest);
		reservationRepo.save(reservation);
		return new BaseResponse("Success", "Reservation placed Successfully");
	}


	private Reservation getReservation(ReservationRequest request) {
		Reservation reservation = new Reservation();
		reservation.setName(request.getName());
		reservation.setGuests(request.getGuests());
		reservation.setPhoneNumber(request.getPhoneNumber());
		reservation.setSmokingPreference(request.getSmokingPreference());
		long millis = System.currentTimeMillis();
		reservation.setBookedAt(new Date(millis));
		reservation.setUser(getUser(request.getUserId()));
		RestaurantBranch branch = getRestaurantBranch(request.getBranchId());
		reservation.setBranch(branch);
		ReservationSlot slot = getBranchSlot(request.getBranchId(),request.getTime());
		reservation.setSlot(slot);
		reservation.setBookingDate(getDatefromString(request.getBookingDate()));
		reservation.setSeatingType(getSeatingType(request.getSeatingPreference()));
		reservation.setStatus(getNewReservationStatus());
		reservation.setComments("Booking");
		return reservation;
	}


	private ReservationStatus getNewReservationStatus() {
		return statusService.getReservationStatus("PENDING");
	}


	private SeatingType getSeatingType(String seatingPreference) {
		return seatingTypeService.getSeatingType(seatingPreference);
	}


	private Date getDatefromString(String dateString) {
		Date date ;
		try {
			 date = Date.valueOf(dateString);;
			}catch(IllegalArgumentException ex) {
				throw new InvalidInputException( dateString +" not in yyyy-mm-dd Format");
			}
		return date;
	}


	private ReservationSlot getBranchSlot(int branchId,String slotTime) {
		ReservationSlot slot = slotService.getBranchSlot(slotTime, branchId);
		if(null == slot) {
			 throw new InvalidInputException("Branch Doesn't Accept Bookings for :"+slotTime);
		}
		return slot;
	}


	private User getUser(int userId) {
		return userService.getUserById(userId);
	}


	private RestaurantBranch getRestaurantBranch(int branchId) {
		return branchService.getBranchById(branchId);
	}
	
	public List<Reservation> getUserReservations(int userId) {
		
		return reservationRepo.findByUser_Id(userId);
	}
	
	public List<Reservation> getBranchReservations(int branchId){
		
		return reservationRepo.findByBranch_Id(branchId);
	}

	public Reservation getReservationById(int reservationId) {
		
		Optional<Reservation>  optionalReservation = reservationRepo.findById(reservationId);
		if(!optionalReservation.isPresent()) {
			throw new RecordNotFoundException("Reservation doesn't exists with id : "+ reservationId);
		}
		return optionalReservation.get();
	}
	
	public void updateReservationStatus(int reservationId, String status) {

		Reservation reservation = getReservationById(reservationId);
		ReservationStatus reservationStatus = getReservationStatus(status);
		reservation.setStatus(reservationStatus);
		
		reservationRepo.save(reservation);
	}
	
private ReservationStatus getReservationStatus(String status) {
		
		ReservationStatus reservationStatus = statusService.getReservationStatus(status.toUpperCase());
		if(Objects.isNull(reservationStatus)) {
			throw new InvalidInputException("Invalid status : "+status);
		}
		return reservationStatus;
	}
}
