/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.models.RestaurantPhoneNumber;
import com.project.restauranttablereservation.service.RestaurantPhoneNumberService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RestaurantPhoneNumberServiceImpl implements RestaurantPhoneNumberService {

	@Override
	public Set<RestaurantPhoneNumber> getPhoneNumbers(Set<String> phoneNumbers) {

		HashSet<RestaurantPhoneNumber> numbers = new HashSet<>();

		phoneNumbers.forEach(number -> {
			RestaurantPhoneNumber phoneno = new RestaurantPhoneNumber(number);
			numbers.add(phoneno);
		});

		return numbers;
	}

}
