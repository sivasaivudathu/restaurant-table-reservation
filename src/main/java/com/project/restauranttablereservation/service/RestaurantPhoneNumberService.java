/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.Set;

import com.project.restauranttablereservation.models.RestaurantPhoneNumber;

/**
 * @author sivasaiv
 *
 */
public interface RestaurantPhoneNumberService {

	public Set<RestaurantPhoneNumber> getPhoneNumbers(Set<String> phoneNumbers);
}
