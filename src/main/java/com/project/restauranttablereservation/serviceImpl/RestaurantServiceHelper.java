/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.restauranttablereservation.constants.SlotStatusType;
import com.project.restauranttablereservation.models.Cuisine;
import com.project.restauranttablereservation.models.PaymentType;
import com.project.restauranttablereservation.models.ReservationSlot;
import com.project.restauranttablereservation.models.RestaurantPhoneNumber;
import com.project.restauranttablereservation.models.RestaurantType;
import com.project.restauranttablereservation.models.SeatingType;
import com.project.restauranttablereservation.models.SlotStatus;
import com.project.restauranttablereservation.repositories.CuisineRepository;
import com.project.restauranttablereservation.repositories.PaymentTypeRepository;
import com.project.restauranttablereservation.repositories.RestaurantTypeRepository;
import com.project.restauranttablereservation.repositories.SeatingTypeRepository;
import com.project.restauranttablereservation.repositories.SlotStatusRepository;

/**
 * @author sivasaiv
 *
 */
@Component
public class RestaurantServiceHelper {

	@Autowired
	CuisineRepository cuisineRepo;

	@Autowired
	PaymentTypeRepository paymentTypeRepo;

	@Autowired
	RestaurantTypeRepository restaurantTypeRepo;

	@Autowired
	SeatingTypeRepository seatingTypeRepo;

	@Autowired
	SlotStatusRepository slotStatuRepo;

	public HashSet<Cuisine> getCuisines(Set<String> cuisines) {

		HashSet<Cuisine> cuisineObjs = new HashSet<>();

		cuisines.forEach(cuisineName -> {

			Optional<Cuisine> optionalCuisine = cuisineRepo.findByName(cuisineName);
			if (optionalCuisine.isPresent()) {
				cuisineObjs.add(optionalCuisine.get());
			} else {
				Cuisine cuisine = new Cuisine(cuisineName);
				cuisineObjs.add(cuisine);
			}

		});

		return cuisineObjs;
	}

	public HashSet<PaymentType> getPaymentTypes(Set<String> paymentTypes) {

		HashSet<PaymentType> paymentTypeObjs = new HashSet<>();

		paymentTypes.forEach(typeName -> {

			Optional<PaymentType> optionalType = paymentTypeRepo.findByType(typeName);
			if (optionalType.isPresent()) {
				paymentTypeObjs.add(optionalType.get());
			} else {
				PaymentType paymentType = new PaymentType(typeName);
				paymentTypeObjs.add(paymentType);
			}

		});

		return paymentTypeObjs;
	}

	public HashSet<RestaurantType> getRestaurantTypes(Set<String> restaurantTypes) {

		HashSet<RestaurantType> restaurantTypeObjs = new HashSet<>();

		restaurantTypes.forEach(typeName -> {

			Optional<RestaurantType> optionalType = restaurantTypeRepo.findByType(typeName);
			if (optionalType.isPresent()) {
				restaurantTypeObjs.add(optionalType.get());
			} else {
				RestaurantType restaurantType = new RestaurantType(typeName);
				restaurantTypeObjs.add(restaurantType);
			}

		});

		return restaurantTypeObjs;
	}

	public HashSet<SeatingType> getSeatingTypes(Set<String> seatingTypes) {

		HashSet<SeatingType> seatingTypeObjs = new HashSet<>();

		seatingTypes.forEach(typeName -> {

			Optional<SeatingType> optionalType = seatingTypeRepo.findByType(typeName);
			if (optionalType.isPresent()) {
				seatingTypeObjs.add(optionalType.get());
			} else {
				SeatingType paymentType = new SeatingType(typeName);
				seatingTypeObjs.add(paymentType);
			}

		});

		return seatingTypeObjs;
	}

	public Set<ReservationSlot> getReservationSlots(Set<String> slots) {

		Set<ReservationSlot> reservationSlots = new HashSet<>();

		slots.forEach(slottime -> {

			ReservationSlot slot = new ReservationSlot(slottime, getSlotStatus(SlotStatusType.AVAILABLE));
			reservationSlots.add(slot);
		});

		return reservationSlots;
	}

	public SlotStatus getSlotStatus(SlotStatusType type) {

		Optional<SlotStatus> optionalStatus = slotStatuRepo.findByStatus(type);
		if (optionalStatus.isPresent()) {
			return optionalStatus.get();
		}

		return new SlotStatus(type);
	}

	public Set<RestaurantPhoneNumber> getPhoneNumbers(Set<String> phoneNumbers) {

		HashSet<RestaurantPhoneNumber> numbers = new HashSet<>();

		phoneNumbers.forEach(number -> {
			RestaurantPhoneNumber phoneno = new RestaurantPhoneNumber(number);
			numbers.add(phoneno);
		});

		return numbers;
	}
}
