/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.api.model.ReservationRequest;
import com.project.restauranttablereservation.api.model.UserReservationsResponse;
import com.project.restauranttablereservation.converters.EntityToDtoConverter;
import com.project.restauranttablereservation.dto.ReservationDto;
import com.project.restauranttablereservation.exceptions.InvalidInputException;
import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.Reservation;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.RestaurantBranch;
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
	public BaseResponse addReservation(ReservationRequest request) {
		
		Reservation reservation = new Reservation();
		Date date ;
		reservation.setName(request.getName());
		reservation.setGuests(request.getGuests());
		reservation.setPhoneNumber(request.getPhoneNumber());
		reservation.setSmokingPreference(request.getSmokingPreference());

		long millis = System.currentTimeMillis();
		reservation.setBookedAt(new Date(millis));
		
		reservation.setUser(userService.getUserById(request.getUserId()));
		
		RestaurantBranch branch = branchService.getBranchById(request.getBranchId());
		
		reservation.setBranch(branch);
		
		ReservationSlot slot = slotService.getBranchSlot(request.getTime(), request.getBranchId());
		
		if(null == slot) {
			 throw new InvalidInputException("Branch Doesn't Accept Bookings for :"+request.getTime());
		}
		reservation.setSlot(slot);
		
		try {
			 date = Date.valueOf(request.getBookingDate());
			}catch(IllegalArgumentException ex) {
				throw new InvalidInputException( request.getBookingDate() +" not in yyyy-mm-dd Format");
			}
		
		reservation.setBookingDate(date);
		
		reservation.setSeatingType(seatingTypeService.getSeatingType(request.getSeatingPreference()));
		reservation.setStatus(statusService.getReservationStatus("PENDING"));
		reservation.setComments("Booking");
		reservationRepo.save(reservation);
		
		BaseResponse response = new BaseResponse();
		
		response.setMessage("Reservation placed Successfully");
		response.setStatus("Success");
		return response;
	}
	
	public UserReservationsResponse getUserReservations(int userId) {
		
		
		List<Reservation> reservations = reservationRepo.findByUser_Id(userId);
		
		List<ReservationDto> reservationsDto = reservations.stream().map(dtoConverter::convertReservationEntity).collect(Collectors.toList());
		
		return new UserReservationsResponse(reservationsDto);
	}

}
