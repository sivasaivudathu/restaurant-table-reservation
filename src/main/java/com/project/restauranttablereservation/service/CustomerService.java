/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.models.BaseResponse;
import com.project.restauranttablereservation.models.User;

/**
 * @author sivasaiv
 *
 */
public interface CustomerService {

	public BaseResponse addUser(User user);
}
